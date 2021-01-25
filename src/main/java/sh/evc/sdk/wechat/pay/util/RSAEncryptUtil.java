package sh.evc.sdk.wechat.pay.util;

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
public class RSAEncryptUtil {

  private static final String CIPHER_PROVIDER = "SunJCE";
  private static final String TRANSFORMATION_PKCS1Paddiing = "RSA/ECB/PKCS1Padding";
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
    Cipher ci = Cipher.getInstance(TRANSFORMATION_PKCS1Paddiing, CIPHER_PROVIDER);
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
   * @param Content
   * @param cert
   * @return
   * @throws Exception
   */
  public static String rsaEncrypt(String Content, String cert) throws Exception {
    final byte[] PublicKeyBytes = cert.getBytes();
    X509Certificate certificate = X509Certificate.getInstance(PublicKeyBytes);
    PublicKey publicKey = certificate.getPublicKey();
    return encodeBase64(encryptPkcs1padding(publicKey, Content.getBytes(CHAR_ENCODING)));
  }

  public static void main(String[] args) throws Exception {
    String aesKey = "sasaAA1h3b7acfahiOswA32E2eU19bu1";
    String associatedData = "certificate";
    String nonce = "91d50721d988";
    String ciphertext = "/trgA/uTSpN3GAWTYfUiN/Nbe5BbQaJsWGEgM3w0msderKzNy6iWxqnrFojT7rymdq1343PwGhcguGFWeKDCPSoKgRtCZwjYgxUc4AKHzjqU3kyG9hdEsWNCgZEx/XQBEqszFTMxhs/UotxT8qbeM8CNO1eCOVD/rjt/n8VzdXVRKHlFVz3cFo7czllr3bi7QXaWeJqUlJDd+JFv9wp0rwgdmnX1QgUdslnn3YPoz3L283xYtpUhjaH5bawh7ADANMOp2Ve+yVg6/4cWAqxPlo1PBZU3zU3wmTXoVaAdLN5Unm5aVP7BulA+DH2F5AL82vbEOWFUdKvIjPyNMlpWkMOXZMgG+Zfq5UBjl3UlCIiPmmDl133z5MC3FVuunFkByWDyapcVjpAnsm3qWnmYJ2ueUd7FXHF9QTbS2juDovuzM/rP4mxB4trdjK7rujefxb75VSNuPvzy7zLZSwI4lZlUMENl8gTDu3BmA6tTTG+wCae3OPV2PSsSA9srBoqo9QFnpB992imVVr12xCoKWlCWQAkez6TpGXJomnY1PLk6RZ1FK1vPNyOQWy+qCcws2UQfFuC23FKbGVKtZlXElmv0xx/JC9w7+NJ30nn8Dv9SleNB6I4D1ZJlz5ImVlqd02DMr4ClZwfRn7U1YXRe/4GCXoQ5+lnrAGw+kVaiOCiUeKwB6oVNhOhJq7Y01SL+xwW7lWvmc/cYdnhdjz/XgSxOISNzPVND60Kdu3fgq21FOVauit/bMQYvKVsI+utf6NmkqRsthDyqbwzHZac6S0VeQEWJW0Uhdyz7joQnqCfAVwLMTV95Acarc8Zgyy4NTHR2oKgsTEb1cu3SeP1iDrxBo2M1W7tZsUXHlIMKbmqQwdYSE2HXS/BhHmD9jE5fniEOV/rw/IF/thDvSbxYkQwKC46R9rpuOHmrE5PDeog8dtawZPXgZcXQ3WUnRxHdES6F4VYsR6qVBGzCZNddorEnwWShf60G0k0smiF1GkP4Hbld5LGlh/z3AJqwELsFTUp6GanxS4P+z5Scb604j2UwPbExS2wyhgFJnXNBEBYTabo0oJXgdLB2Ie0HBGBrCchloQRN41A+XGIeQXKsvNXI0+AV6vz0AboSYXd2cb8X6f4lAOn8AjksZXtl//IcWw4VPsloGdJ0LBZ10r21S+5U8yJ4jzb+vLLK1gif1CFLFPTsTp0SD5a8KGltMNDM5/OFQWG6lzDMshRzsTn3i/yh2sdEI3LKHHuFz6zJEJ2Tg45wnaB73uAkhBKvSLuDFkBAh5WBV0Lxp0lEFNDS2675XXwSpXCY+lbSs5PzRa6ezwBQVIA+6dEWxg7PdlijZetlwcnWlabQW2Jd0gkJKd7wRK06fchIPbavtGW+SpIp1o24ahj+kHHqvXnliSy5dQZVIZtBK9PFNPYR02ZDQqM1epw9VnIlzyCpOeAvV/IWb+4+ebmvgxpcjBHeqwGR2gQdpWNgZ83WHOaDo9nL1OXHBXs4Pp5CeuXIWa2rzX/W/mYU2G2Sb0RhRD+xO0xu69/mKCsopg4CiND6IUw/dReNWfMBI6EUwEZjChs5K9qr/+kENADA3r3IsLgAvKe+MtLksWPk/Ns8mUD4r3EYsDHhoLS2suyuK7WubeYRq4hKzBuZFu6+jSL0tT+ydVH3tmCEe4tBEmNCG+ZUGTFn9Qs/dCy5bsa18dF5EUvN+QAUHf3HSEngg4Y27381LW7z0+ECK81E3VENF8pKUZyMjLAtVD+KKGndVRkEzJQ3R6dtnkmLzbTPDLnQsO2M52RAVqTbqxFxONwtfxXLXo4TLs9BcR7jl7bgKvCTADXyXodYrWRUsd5GqaZX7tiiypdldqKFvt9Ay+K3QN+Wp9bS3EBr+2BGDw==";

    String cert = SignatureUtil.aesgcmDecrypt(associatedData, nonce, ciphertext, aesKey);

    System.out.println(rsaEncrypt("要加密的内容", cert));
  }
}
