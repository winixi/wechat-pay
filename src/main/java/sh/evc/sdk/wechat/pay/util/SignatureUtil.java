package sh.evc.sdk.wechat.pay.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.Const;
import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.domain.PayNotify;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Security;
import java.util.*;

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
      throw new RuntimeException(errorString); // hack failed
    }

    //添加PKCS7Padding支持
    Security.addProvider(new BouncyCastleProvider());
  }

  private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final Random RANDOM = new SecureRandom();

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
   * @throws Exception
   */
  public static boolean isSignatureValid(Map<String, String> respData, String key, SignType signType) throws Exception {

    //如果没有sign字段那么就是不需要验证签名，直接过
    if (!respData.containsKey(Const.FIELD_SIGN)) {
      return true;
    }
    String sign = respData.get(Const.FIELD_SIGN);

    //如果指定了签名方式，那么就用指定的方式
    if (respData.containsKey(Const.FIELD_SIGN_TYPE)) {
      signType = SignType.find(respData.get(Const.FIELD_SIGN_TYPE));
    }

    return generateSignature(respData, key, signType).equals(sign);
  }

  /**
   * 默认从结构体中找sign_type
   *
   * @param data
   * @param key
   * @return
   * @throws Exception
   */
  public static String generateSignature(final Map<String, String> data, String key) throws Exception {
    return generateSignature(data, key, null);
  }

  /**
   * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
   *
   * @param data     待签名数据
   * @param key      API密钥
   * @param signType 签名方式
   * @return 签名
   */
  public static String generateSignature(final Map<String, String> data, String key, SignType signType) throws Exception {
    Set<String> keySet = data.keySet();
    String[] keyArray = keySet.toArray(new String[keySet.size()]);
    Arrays.sort(keyArray);
    StringBuilder sb = new StringBuilder();
    for (String k : keyArray) {
      if (k.equals(Const.FIELD_SIGN)) {
        continue;
      }
      if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
        sb.append(k).append("=").append(data.get(k).trim()).append("&");
    }
    sb.append("key=").append(key);

    //如果指名了签名方式就按指明的定
    String type = data.get("sign_type");
    if (type != null) {
      signType = SignType.find(type);
    }
    if (SignType.MD5 == signType) {
      return MD5(sb.toString()).toUpperCase(); //转成大写
    } else if (SignType.HMACSHA256 == signType) {
      return HMACSHA256(sb.toString(), key);
    } else {
      throw new Exception(String.format("Invalid sign_type: %s", signType));
    }
  }

  /**
   * 获取随机字符串 Nonce Str
   *
   * @return String 随机字符串
   */
  public static String generateNonceStr() {
    char[] nonceChars = new char[32];
    for (int index = 0; index < nonceChars.length; ++index) {
      nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
    }
    return new String(nonceChars);
  }

  /**
   * 生成 MD5
   *
   * @param data 待处理数据
   * @return MD5结果
   */
  public static String MD5(String data) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] array = md.digest(data.getBytes("UTF-8"));
    StringBuilder sb = new StringBuilder();
    for (byte item : array) {
      sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
    }
    return sb.toString().toUpperCase();
  }

  /**
   * 生成 HMACSHA256
   *
   * @param data 待处理数据
   * @param key  密钥
   * @return 加密结果
   * @throws Exception
   */
  public static String HMACSHA256(String data, String key) throws Exception {
    Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
    SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
    sha256_HMAC.init(secret_key);
    byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
    StringBuilder sb = new StringBuilder();
    for (byte item : array) {
      sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
    }
    return sb.toString().toUpperCase();
  }

  /**
   * 主函数
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    String xml = "<xml><appid><![CDATA[wxc41ba77c696fb673]]></appid>\n" +
            "<attach><![CDATA[云峦足球场]]></attach>\n" +
            "<bank_type><![CDATA[CCB_CREDIT]]></bank_type>\n" +
            "<cash_fee><![CDATA[2500]]></cash_fee>\n" +
            "<device_info><![CDATA[BOSS207]]></device_info>\n" +
            "<fee_type><![CDATA[CNY]]></fee_type>\n" +
            "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
            "<mch_id><![CDATA[1516531731]]></mch_id>\n" +
            "<nonce_str><![CDATA[PWiQUqI3mQnV4lMXBlj3QI0FLlahDdd4]]></nonce_str>\n" +
            "<openid><![CDATA[oGimf4qeCWxq27fkhLPkyF6fs85M]]></openid>\n" +
            "<out_trade_no><![CDATA[G207U8014P2021012008382933]]></out_trade_no>\n" +
            "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
            "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
            "<sign><![CDATA[F997A5924987BBF1B63E9B46A3944AA17E43DB1A63209909EEBE8E3E86B0644D]]></sign>\n" +
            "<time_end><![CDATA[20210120083837]]></time_end>\n" +
            "<total_fee>2500</total_fee>\n" +
            "<trade_type><![CDATA[JSAPI]]></trade_type>\n" +
            "<transaction_id><![CDATA[4200000845202101207738856295]]></transaction_id>\n" +
            "</xml>";
    PayNotify notify = SerializeUtil.xmlToBean(xml, PayNotify.class);
    log.info(notify.toString());
    log.info(SerializeUtil.beanToXml(notify));

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
