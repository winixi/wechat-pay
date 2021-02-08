package sh.evc.sdk.wechat.pay.domain;

/**
 * 证书数据
 *
 * @author winixi
 * @date 2021/2/8 3:40 PM
 */
public class CertificateData {

  /**
   * 序列号
   */
  private String serialNo;

  /**
   * 生效时间
   */
  private String effectiveTime;

  /**
   * 失效时间
   */
  private String expireTime;

  /**
   * 加密证书
   */
  private EncryptCertificate encryptCertificate;

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public String getEffectiveTime() {
    return effectiveTime;
  }

  public void setEffectiveTime(String effectiveTime) {
    this.effectiveTime = effectiveTime;
  }

  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }

  public EncryptCertificate getEncryptCertificate() {
    return encryptCertificate;
  }

  public void setEncryptCertificate(EncryptCertificate encryptCertificate) {
    this.encryptCertificate = encryptCertificate;
  }

  @Override
  public String toString() {
    return "CertificateData{" +
            "serialNo='" + serialNo + '\'' +
            ", effectiveTime='" + effectiveTime + '\'' +
            ", expireTime='" + expireTime + '\'' +
            ", encryptCertificate=" + encryptCertificate +
            '}';
  }
}
