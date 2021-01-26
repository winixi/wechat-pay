package sh.evc.sdk.wechat.pay.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.Const;
import sh.evc.sdk.wechat.pay.dict.SignType;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.Set;

/**
 * 微信支付工具
 *
 * @author winixi
 * @date 2018/11/22 11:42 PM
 */
@SuppressWarnings("unchecked")
public class SignatureUtil {

  private final static Logger log = LoggerFactory.getLogger(SignatureUtil.class);

  //美国限制技术出口，禁止128以上的AES秘钥，这里运行hack掉这个限制
  static {
    String errorString = "Failed manually overriding key-length permissions.";
    int newMaxKeyLength;
    try {
      if ((newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES")) < 256) {
        Class<?> c = Class.forName("javax.crypto.CryptoAllPermissionCollection");
        Constructor con = c.getDeclaredConstructor();
        con.setAccessible(true);
        Object allPermissionCollection = con.newInstance();
        Field f = c.getDeclaredField("all_allowed");
        f.setAccessible(true);
        f.setBoolean(allPermissionCollection, true);
        c = Class.forName("javax.crypto.CryptoPermissions");
        con = c.getDeclaredConstructor();
        con.setAccessible(true);
        Object allPermissions = con.newInstance();
        f = c.getDeclaredField("perms");
        f.setAccessible(true);
        ((Map) f.get(allPermissions)).put("*", allPermissionCollection);
        c = Class.forName("javax.crypto.JceSecurityManager");
        f = c.getDeclaredField("defaultPolicy");
        f.setAccessible(true);
        Field mf = Field.class.getDeclaredField("modifiers");
        mf.setAccessible(true);
        mf.setInt(f, f.getModifiers() & ~Modifier.FINAL);
        f.set(null, allPermissions);
        newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES");
      }
    } catch (Exception e) {
      throw new RuntimeException(errorString, e);
    }
    if (newMaxKeyLength < 256) {
      // hack failed
      throw new RuntimeException(errorString);
    }

    //添加PKCS7Padding支持
    Security.addProvider(new BouncyCastleProvider());
  }

  /**
   * 使用商户后台APIv3密钥来解密
   *
   * @param aad
   * @param iv
   * @param cipherText
   * @param aesKey
   * @return
   * @throws Exception
   */
  public static String aesgcmDecrypt(String aad, String iv, String cipherText, String aesKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(), "AES");
    GCMParameterSpec spec = new GCMParameterSpec(128, iv.getBytes());
    cipher.init(Cipher.DECRYPT_MODE, key, spec);
    cipher.updateAAD(aad.getBytes());
    return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
  }

  /**
   * 退款req_info解密
   *
   * @param reqInfo
   * @param apiKey
   * @return
   * @throws Exception
   */
  public static String reqInfoDecrypt(String reqInfo, String apiKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    String md5 = DigestUtils.md5Hex(apiKey).toLowerCase();
    SecretKeySpec key = new SecretKeySpec(md5.getBytes(), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key);    //没有偏移量

//    byte[] content = new BASE64Decoder().decodeBuffer(reqInfo);    //需要解密的内容
//    byte[] data = cipher.doFinal(content);
//    return new String(data, "UTF-8");
    return new String(cipher.doFinal(Base64Util.decode8859(reqInfo).getBytes("ISO-8859-1")), "utf-8");
  }

  /**
   * req_info加密
   *
   * @param reqInfo
   * @param apiKey
   * @return
   * @throws Exception
   */
  public static String reqInfoEncrypt(String reqInfo, String apiKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    String md5 = DigestUtils.md5Hex(apiKey).toLowerCase();
    SecretKeySpec key = new SecretKeySpec(md5.getBytes(), "AES");
    cipher.init(Cipher.ENCRYPT_MODE, key);

//    byte[] data = cipher.doFinal(reqInfo.getBytes());
//    return new BASE64Encoder().encode(data);
    return Base64Util.encode8859(new String(cipher.doFinal(reqInfo.getBytes()), "ISO-8859-1"));
  }

  /**
   * 获取到证书内容
   *
   * @param data
   * @param aesKey
   * @return
   * @throws Exception
   */
  public static String getCertContent(JSONArray data, String aesKey) throws Exception {
    //敏感信息证书生成所需参数
    String encryptCertificate = JSONObject.parseObject(JSONObject.toJSONString(data.get(0))).getString("encrypt_certificate");
    String nonce = JSONObject.parseObject(encryptCertificate).getString("nonce");
    String associatedData = JSONObject.parseObject(encryptCertificate).getString("associated_data");

    //要被解密的证书字符串
    String cipherText = JSONObject.parseObject(encryptCertificate).getString("ciphertext");
    return aesgcmDecrypt(associatedData, nonce, cipherText, aesKey);
  }

  /**
   * 判断签名是否正确
   *
   * @param respData
   * @param key      API密钥
   * @param signType
   * @return 签名是否正确
   */
  public static boolean isValid(ParamsMap respData, String key, SignType signType) {

    //如果没有sign字段那么就是不需要验证签名，直接过
    if (!respData.containsKey(Const.FIELD_SIGN)) {
      return true;
    }
    String sign = respData.get(Const.FIELD_SIGN);

    //如果指定了签名方式，那么就用指定的方式
    if (respData.containsKey(Const.FIELD_SIGN_TYPE)) {
      signType = SignType.find(respData.get(Const.FIELD_SIGN_TYPE));
    }

    return generate(respData, key, signType).equals(sign);
  }

  /**
   * 默认从结构体中找sign_type
   *
   * @param data
   * @param key
   * @return
   */
  public static String generate(final ParamsMap data, String key) {
    return generate(data, key, null);
  }

  /**
   * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
   *
   * @param data     待签名数据
   * @param key      API密钥
   * @param signType 签名方式
   * @return 签名
   */
  public static String generate(final ParamsMap data, String key, SignType signType) {
    Set<String> keySet = data.keySet();
    String[] keyArray = keySet.toArray(new String[0]);
    Arrays.sort(keyArray);
    StringBuilder sb = new StringBuilder();
    for (String k : keyArray) {
      if (k.equals(Const.FIELD_SIGN)) {
        continue;
      }
      // 参数值为空，则不参与签名
      if (data.get(k).trim().length() > 0) {
        sb.append(k).append("=").append(data.get(k).trim()).append("&");
      }
    }
    sb.append("key=").append(key);

    //如果指名了签名方式就按指明的定
    String type = data.get("sign_type");
    if (type != null) {
      signType = SignType.find(type);
    }

    try {
      if (SignType.MD5 == signType) {
        //转成大写
        return MD5(sb.toString()).toUpperCase();
      } else if (SignType.HMACSHA256 == signType) {
        return HMACSHA256(sb.toString(), key);
      } else {
        log.error("sign_type无法识别{}", signType);
      }
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
      log.error(ErrorUtil.getStackTraceAsString(e));
    }
    return null;
  }

  /**
   * 生成 MD5
   *
   * @param data 待处理数据
   * @return MD5结果
   * @throws NoSuchAlgorithmException
   * @throws UnsupportedEncodingException
   */
  public static String MD5(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] array = md.digest(data.getBytes("UTF-8"));
    StringBuilder sb = new StringBuilder();
    for (byte item : array) {
      sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
    }
    return sb.toString().toUpperCase();
  }

  /**
   * 生成 HMACSHA256
   *
   * @param data
   * @param key
   * @return
   * @throws NoSuchAlgorithmException
   * @throws UnsupportedEncodingException
   * @throws InvalidKeyException
   */
  public static String HMACSHA256(String data, String key) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
    Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
    SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
    sha256_HMAC.init(secret_key);
    byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
    StringBuilder sb = new StringBuilder();
    for (byte item : array) {
      sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
    }
    return sb.toString().toUpperCase();
  }

  /**
   * 主函数
   *
   * @param args
   */
  public static void main(String[] args) {

//    String a = "adfasdfasdfsd";
//    String key = "adasdfasdfsadfasdfsdf";
//    log.info("原内容:" + a);
//
//    String encode = reqInfoEncrypt(a, key);
//    log.info("加密后:" + encode);
//
//    String decode = reqInfoDecrypt(encode, key);
//    log.info("解密后:" + decode);
  }
}
