package sh.evc.sdk.wechat.pay.response.pay;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 关闭订单
 *
 * @author winixi
 * @date 2021/1/27 1:41 PM
 */
public class CloseOrderResponse extends XmlResponse {

  /**
   * 服务商的APPID
   */
  private String appId;

  /**
   * 子商户公众账号ID
   */
  private String subAppId;

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

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
    return "CloseOrderResponse{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            '}';
  }
}
