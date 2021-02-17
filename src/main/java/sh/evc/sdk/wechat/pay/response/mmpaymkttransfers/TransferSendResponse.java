package sh.evc.sdk.wechat.pay.response.mmpaymkttransfers;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 企业付款
 *
 * @author winixi
 * @date 2021/2/17 2:19 PM
 */
public class TransferSendResponse extends XmlResponse {

  /**
   * 商户账号appid
   * 申请商户号的appid或商户号绑定的appid
   */
  @JsonProperty("mch_appid")
  private String mchAppId;

  /**
   * 微信支付申请的商户号
   */
  @JsonProperty("mchid")
  private String mchId;

  /**
   * 设备号
   */
  private String deviceInfo;

  /**
   * 随机字符串，不长于32位
   */
  private String nonceStr;

  /**
   * 商户订单号，需保持唯一性
   * (只能是字母或者数字，不能包含有其它字符)
   */
  private String partnerTradeNo;

  /**
   * 企业付款成功，返回的微信付款单号
   */
  private String paymentNo;

  /**
   * 付款成功时间
   */
  private String paymentTime;

  public String getMchAppId() {
    return mchAppId;
  }

  public void setMchAppId(String mchAppId) {
    this.mchAppId = mchAppId;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getDeviceInfo() {
    return deviceInfo;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getPartnerTradeNo() {
    return partnerTradeNo;
  }

  public void setPartnerTradeNo(String partnerTradeNo) {
    this.partnerTradeNo = partnerTradeNo;
  }

  public String getPaymentNo() {
    return paymentNo;
  }

  public void setPaymentNo(String paymentNo) {
    this.paymentNo = paymentNo;
  }

  public String getPaymentTime() {
    return paymentTime;
  }

  public void setPaymentTime(String paymentTime) {
    this.paymentTime = paymentTime;
  }

  @Override
  public String toString() {
    return "TransferSendResponse{" +
            "mchAppId='" + mchAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", deviceInfo='" + deviceInfo + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", partnerTradeNo='" + partnerTradeNo + '\'' +
            ", paymentNo='" + paymentNo + '\'' +
            ", paymentTime='" + paymentTime + '\'' +
            "} " + super.toString();
  }
}
