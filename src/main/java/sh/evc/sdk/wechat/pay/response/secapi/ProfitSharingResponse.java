package sh.evc.sdk.wechat.pay.response.secapi;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 单次分账返回
 *
 * @author winixi
 * @date 2021/1/23 5:17 PM
 */
public class ProfitSharingResponse extends XmlResponse {

  /**
   * 主商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 品牌主商户号
   */
  private String brandMchId;

  /**
   * 公众帐号id
   */
  private String appId;

  /**
   * 子商户公众账号id
   */
  private String subAppId;

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public String getBrandMchId() {
    return brandMchId;
  }

  public void setBrandMchId(String brandMchId) {
    this.brandMchId = brandMchId;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getSubAppId() {
    return subAppId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
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

  @Override
  public String toString() {
    return "ProfitSharingResponse{" +
            "mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", brandMchId='" + brandMchId + '\'' +
            ", appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
