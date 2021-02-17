package sh.evc.sdk.wechat.pay.response.mmpaymkttransfers;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.dict.TransferStatus;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 企业付款查询
 *
 * @author winixi
 * @date 2021/2/17 2:20 PM
 */
public class TransferQueryResponse extends XmlResponse {

  /**
   * 商户号的appid
   */
  @JsonProperty("appid")
  private String appId;

  /**
   * 微信支付分配的商户号
   */
  @JsonProperty("mchid")
  private String mchId;

  /**
   * 商户调用企业付款API时使用的商户订单号
   */
  private String partnerTradeNo;

  /**
   * 调用企业付款API时，微信系统内部产生的单号
   */
  private String detailId;

  /**
   * 转账状态
   */
  private TransferStatus status;

  /**
   * 如果失败则有失败原因
   */
  private String reason;

  /**
   * 收款用户openid
   */
  @JsonProperty("openid")
  private String openId;

  /**
   * 收款用户姓名
   */
  private String transferName;

  /**
   * 付款金额单位为“分”
   */
  private Integer paymentAmount;

  /**
   * 发起转账的时间
   */
  private String transferTime;

  /**
   * 企业付款成功时间
   */
  private String paymentTime;

  /**
   * 企业付款备注
   */
  private String desc;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getPartnerTradeNo() {
    return partnerTradeNo;
  }

  public void setPartnerTradeNo(String partnerTradeNo) {
    this.partnerTradeNo = partnerTradeNo;
  }

  public String getDetailId() {
    return detailId;
  }

  public void setDetailId(String detailId) {
    this.detailId = detailId;
  }

  public TransferStatus getStatus() {
    return status;
  }

  public void setStatus(TransferStatus status) {
    this.status = status;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getTransferName() {
    return transferName;
  }

  public void setTransferName(String transferName) {
    this.transferName = transferName;
  }

  public Integer getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(Integer paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public String getTransferTime() {
    return transferTime;
  }

  public void setTransferTime(String transferTime) {
    this.transferTime = transferTime;
  }

  public String getPaymentTime() {
    return paymentTime;
  }

  public void setPaymentTime(String paymentTime) {
    this.paymentTime = paymentTime;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return "TransferQueryResponse{" +
            "appId='" + appId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", partnerTradeNo='" + partnerTradeNo + '\'' +
            ", detailId='" + detailId + '\'' +
            ", status=" + status +
            ", reason='" + reason + '\'' +
            ", openId='" + openId + '\'' +
            ", transferName='" + transferName + '\'' +
            ", paymentAmount=" + paymentAmount +
            ", transferTime='" + transferTime + '\'' +
            ", paymentTime='" + paymentTime + '\'' +
            ", desc='" + desc + '\'' +
            "} " + super.toString();
  }
}
