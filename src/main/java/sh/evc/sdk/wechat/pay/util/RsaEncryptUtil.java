package sh.evc.sdk.wechat.pay.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
import java.security.PublicKey;
import java.util.Base64;

/**
 * RSA加密
 *
 * @author winixi
 * @date 2019-05-23 16:23
 */
public class RsaEncryptUtil {

  private final static Logger log = LoggerFactory.getLogger(RsaEncryptUtil.class);

  private static final String CIPHER_PROVIDER = "SunJCE";
  private static final String TRANSFORMATION_PKCS1Padding = "RSA/ECB/PKCS1Padding";
  private static final String CHAR_ENCODING = "UTF-8";

  /**
   * 数据加密方法
   *
   * @param publicKey
   * @param data
   * @return
   * @throws Exception
   */
  private static byte[] encryptPkcs1padding(PublicKey publicKey, byte[] data) throws Exception {
    Cipher ci = Cipher.getInstance(TRANSFORMATION_PKCS1Padding, CIPHER_PROVIDER);
    ci.init(Cipher.ENCRYPT_MODE, publicKey);
    return ci.doFinal(data);
  }

  /**
   * 加密后的秘文，使用base64编码方法
   *
   * @param bytes
   * @return
   */
  private static String encodeBase64(byte[] bytes) {
    return Base64.getEncoder().encodeToString(bytes);
  }

  /**
   * RSA加密
   *
   * @param content
   * @param cert
   * @return
   */
  public static String rsaEncrypt(String content, String cert) {
    if (StringUtil.isEmpty(content)) {
      return null;
    }
    final byte[] PublicKeyBytes = cert.getBytes();
    X509Certificate certificate;
    try {
      certificate = X509Certificate.getInstance(PublicKeyBytes);
      PublicKey publicKey = certificate.getPublicKey();
      return encodeBase64(encryptPkcs1padding(publicKey, content.getBytes(CHAR_ENCODING)));
    } catch (Exception e) {
      log.error("RSA加密错误{}", ErrorUtil.getStackTraceAsString(e));
    }
    return null;
  }
}
