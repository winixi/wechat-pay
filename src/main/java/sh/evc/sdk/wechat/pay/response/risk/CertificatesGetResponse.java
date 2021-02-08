package sh.evc.sdk.wechat.pay.response.risk;

import sh.evc.sdk.wechat.pay.domain.Certificate;
import sh.evc.sdk.wechat.pay.response.XmlResponse;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 获取平台证书
 *
 * @author winixi
 * @date 2021/2/8 3:26 PM
 */
public class CertificatesGetResponse extends XmlResponse {

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  /**
   * 证书内容
   */
  private String certificates;

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public Certificate getCertificates() {
    return SerializeUtil.jsonToBean(certificates, Certificate.class);
  }

  /**
   * 获取证书序列号
   *
   * @return
   */
  public String getCertSn() {
    Certificate certificate = getCertificates();
    return certificate.getData()[0].getSerialNo();
  }

  /**
   * 获取证书内容
   *
   * @return
   */
  public String getCertText() {
    Certificate certificate = getCertificates();
    return certificate.getData()[0].getEncryptCertificate().getCiphertext();
  }

  public void setCertificates(String certificates) {
    this.certificates = certificates;
  }

  @Override
  public String toString() {
    return "CertficatesGetResponse{" +
            "mchId='" + mchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", certificates='" + certificates + '\'' +
            "} " + super.toString();
  }
}
