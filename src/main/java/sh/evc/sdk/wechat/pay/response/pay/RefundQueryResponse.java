package sh.evc.sdk.wechat.pay.response.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.dict.*;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 退款查询
 *
 * @author winixi
 * @date 2021/1/27 3:03 PM
 */
public class RefundQueryResponse extends XmlResponse {

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
   * 微信支付订单号
   */
  private String transactionId;

  /**
   * 商户订单号
   */
  private String outTradeNo;

  /**
   * 订单金额
   */
  private Integer totalFee;

  /**
   * 应结订单金额
   */
  private Integer settlementTotalFee;

  /**
   * 货币种类
   */
  private FeeType feeType;

  /**
   * 现金支付金额
   */
  private Integer cashFee;

  /**
   * 退款笔数
   */
  private Integer refundCount;

  /**
   * 商户退款单号
   */
  @JsonProperty("out_refund_no_0")
  private String outRefundNo0;

  /**
   * 微信退款单号
   */
  @JsonProperty("refund_id_0")
  private String refundId0;

  /**
   * 退款渠道
   */
  @JsonProperty("refund_channel_0")
  private RefundChannel refundChannel0;

  /**
   * 订单总退款次数
   */
  private Integer totalRefundCount;

  /**
   * 申请退款金额
   */
  @JsonProperty("refund_fee_0")
  private Integer refundFee0;

  /**
   * 退款金额
   */
  @JsonProperty("settlement_refund_fee_0")
  private Integer settlementRefundFee0;

  /**
   * 代金券类型
   */
  @JsonProperty("coupon_type_0")
  private CouponType couponType0;

  /**
   * 退款代金券ID
   */
  @JsonProperty("coupon_refund_id_0")
  private String couponRefundId0;

  /**
   * 单个代金券退款金额
   */
  @JsonProperty("coupon_refund_fee_0")
  private Integer couponRefundFee0;

  /**
   * 退款状态
   */
  @JsonProperty("refund_status_0")
  private RefundStatus refundStatus0;

  /**
   * 退款资金来源
   */
  @JsonProperty("refund_account_0")
  private RefundAccount refundAccount0;

  /**
   * 退款入账账户
   */
  @JsonProperty("refund_recv_accout_0")
  private String refundRecvAccout0;

  /**
   * 退款成功时间，2016-07-25 15:26:26
   */
  @JsonProperty("refund_success_time_0")
  private String refundSuccessTime0;

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

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public Integer getSettlementTotalFee() {
    return settlementTotalFee;
  }

  public void setSettlementTotalFee(Integer settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
  }

  public FeeType getFeeType() {
    return feeType;
  }

  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }

  public Integer getCashFee() {
    return cashFee;
  }

  public void setCashFee(Integer cashFee) {
    this.cashFee = cashFee;
  }

  public Integer getRefundCount() {
    return refundCount;
  }

  public void setRefundCount(Integer refundCount) {
    this.refundCount = refundCount;
  }

  public String getOutRefundNo0() {
    return outRefundNo0;
  }

  public void setOutRefundNo0(String outRefundNo0) {
    this.outRefundNo0 = outRefundNo0;
  }

  public String getRefundId0() {
    return refundId0;
  }

  public void setRefundId0(String refundId0) {
    this.refundId0 = refundId0;
  }

  public RefundChannel getRefundChannel0() {
    return refundChannel0;
  }

  public void setRefundChannel0(RefundChannel refundChannel0) {
    this.refundChannel0 = refundChannel0;
  }

  public Integer getTotalRefundCount() {
    return totalRefundCount;
  }

  public void setTotalRefundCount(Integer totalRefundCount) {
    this.totalRefundCount = totalRefundCount;
  }

  public Integer getRefundFee0() {
    return refundFee0;
  }

  public void setRefundFee0(Integer refundFee0) {
    this.refundFee0 = refundFee0;
  }

  public Integer getSettlementRefundFee0() {
    return settlementRefundFee0;
  }

  public void setSettlementRefundFee0(Integer settlementRefundFee0) {
    this.settlementRefundFee0 = settlementRefundFee0;
  }

  public CouponType getCouponType0() {
    return couponType0;
  }

  public void setCouponType0(CouponType couponType0) {
    this.couponType0 = couponType0;
  }

  public String getCouponRefundId0() {
    return couponRefundId0;
  }

  public void setCouponRefundId0(String couponRefundId0) {
    this.couponRefundId0 = couponRefundId0;
  }

  public Integer getCouponRefundFee0() {
    return couponRefundFee0;
  }

  public void setCouponRefundFee0(Integer couponRefundFee0) {
    this.couponRefundFee0 = couponRefundFee0;
  }

  public RefundStatus getRefundStatus0() {
    return refundStatus0;
  }

  public void setRefundStatus0(RefundStatus refundStatus0) {
    this.refundStatus0 = refundStatus0;
  }

  public RefundAccount getRefundAccount0() {
    return refundAccount0;
  }

  public void setRefundAccount0(RefundAccount refundAccount0) {
    this.refundAccount0 = refundAccount0;
  }

  public String getRefundRecvAccout0() {
    return refundRecvAccout0;
  }

  public void setRefundRecvAccout0(String refundRecvAccout0) {
    this.refundRecvAccout0 = refundRecvAccout0;
  }

  public String getRefundSuccessTime0() {
    return refundSuccessTime0;
  }

  public void setRefundSuccessTime0(String refundSuccessTime0) {
    this.refundSuccessTime0 = refundSuccessTime0;
  }

  @Override
  public String toString() {
    return "RefundQueryResponse{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", transactionId='" + transactionId + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", totalFee=" + totalFee +
            ", settlementTotalFee=" + settlementTotalFee +
            ", feeType=" + feeType +
            ", cashFee=" + cashFee +
            ", refundCount=" + refundCount +
            ", outRefundNo0='" + outRefundNo0 + '\'' +
            ", refundId0='" + refundId0 + '\'' +
            ", refundChannel0=" + refundChannel0 +
            ", totalRefundCount=" + totalRefundCount +
            ", refundFee0=" + refundFee0 +
            ", settlementRefundFee0=" + settlementRefundFee0 +
            ", couponType0=" + couponType0 +
            ", couponRefundId0='" + couponRefundId0 + '\'' +
            ", couponRefundFee0=" + couponRefundFee0 +
            ", refundStatus0=" + refundStatus0 +
            ", refundAccount0=" + refundAccount0 +
            ", refundRecvAccout0='" + refundRecvAccout0 + '\'' +
            ", refundSuccessTime0='" + refundSuccessTime0 + '\'' +
            "} " + super.toString();
  }
}
