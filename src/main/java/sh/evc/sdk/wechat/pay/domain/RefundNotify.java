package sh.evc.sdk.wechat.pay.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 退款通知
 *
 * @author winixi
 * @date 2021/1/27 3:22 PM
 */
@JacksonXmlRootElement(localName = "xml")
public class RefundNotify extends XmlResponse {

  /**
   * 服务商的APPID
   */
  @JsonProperty("appid")
  private String appId;

  /**
   * 子商户公众账号ID
   */
  @JsonProperty("sub_appid")
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

  /**
   * 加密信息
   */
  private String reqInfo;

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

  public String getReqInfo() {
    return reqInfo;
  }

  public void setReqInfo(String reqInfo) {
    this.reqInfo = reqInfo;
  }

  @Override
  public String toString() {
    return "RefundNotify{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", reqInfo='" + reqInfo + '\'' +
            "} " + super.toString();
  }
}
