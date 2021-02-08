package sh.evc.sdk.wechat.pay.domain;

/**
 * 证书加密内容
 *
 * @author winixi
 * @date 2021/2/8 3:40 PM
 */
public class EncryptCertificate {

  /**
   * 算法
   */
  private String algorithm;

  /**
   * 随机数
   */
  private String nonce;

  /**
   * 相关内容
   */
  private String associatedData;

  /**
   * 密码文本
   */
  private String ciphertext;

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public String getNonce() {
    return nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public String getAssociatedData() {
    return associatedData;
  }

  public void setAssociatedData(String associatedData) {
    this.associatedData = associatedData;
  }

  public String getCiphertext() {
    return ciphertext;
  }

  public void setCiphertext(String ciphertext) {
    this.ciphertext = ciphertext;
  }

  @Override
  public String toString() {
    return "CertificateEncrypt{" +
            "algorithm='" + algorithm + '\'' +
            ", nonce='" + nonce + '\'' +
            ", associatedData='" + associatedData + '\'' +
            ", ciphertext='" + ciphertext + '\'' +
            '}';
  }
}
