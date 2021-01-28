package sh.evc.sdk.wechat.pay.response.pay;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 查询最大分账比例
 *
 * @author winixi
 * @date 2021/1/28 4:19 PM
 */
public class ProfitSharingMerchantRatioQueryResponse extends XmlResponse {

  /**
   * 商户号
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
   * 最大分账比例
   * 子商户允许服务商分账的最大比例，单位万分比，比如2000表示20%
   */
  private Integer maxRatio;

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

  public Integer getMaxRatio() {
    return maxRatio;
  }

  public void setMaxRatio(Integer maxRatio) {
    this.maxRatio = maxRatio;
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
    return "ProfitSharingMerchantRatioQueryResponse{" +
            "mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", brandMchId='" + brandMchId + '\'' +
            ", maxRatio=" + maxRatio +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
