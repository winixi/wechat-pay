package sh.evc.sdk.wechat.pay.response.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.dict.CouponType;
import sh.evc.sdk.wechat.pay.dict.FeeType;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 退款返回
 *
 * @author winixi
 * @date 2021/1/27 1:56 PM
 */
public class RefundResponse extends XmlResponse {

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

  /**
   * 微信支付订单号
   */
  private String transactionId;

  /**
   * 商户订单号
   */
  private String outTradeNo;

  /**
   * 商户退款单号
   */
  private String outRefundNo;

  /**
   * 微信退款单号
   */
  private String refundId;

  /**
   * 申请退款金额
   */
  private Integer refundFee;

  /**
   * 退款金额
   */
  private Integer settlementRefundFee;

  /**
   * 货币种类
   */
  private FeeType feeType;

  /**
   * 现金支付金额
   */
  private Integer cashFee;

  /**
   * 现金退款金额
   */
  private Integer cashRefundFee;

  /**
   * 代金券退款总金额
   */
  private Integer couponRefundFee;

  /**
   * 退款代金券使用数量
   */
  private Integer couponRefundCount;

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

  public String getOutRefundNo() {
    return outRefundNo;
  }

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }

  public String getRefundId() {
    return refundId;
  }

  public void setRefundId(String refundId) {
    this.refundId = refundId;
  }

  public Integer getRefundFee() {
    return refundFee;
  }

  public void setRefundFee(Integer refundFee) {
    this.refundFee = refundFee;
  }

  public Integer getSettlementRefundFee() {
    return settlementRefundFee;
  }

  public void setSettlementRefundFee(Integer settlementRefundFee) {
    this.settlementRefundFee = settlementRefundFee;
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

  public Integer getCashRefundFee() {
    return cashRefundFee;
  }

  public void setCashRefundFee(Integer cashRefundFee) {
    this.cashRefundFee = cashRefundFee;
  }

  public Integer getCouponRefundFee() {
    return couponRefundFee;
  }

  public void setCouponRefundFee(Integer couponRefundFee) {
    this.couponRefundFee = couponRefundFee;
  }

  public Integer getCouponRefundCount() {
    return couponRefundCount;
  }

  public void setCouponRefundCount(Integer couponRefundCount) {
    this.couponRefundCount = couponRefundCount;
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

  @Override
  public String toString() {
    return "RefundResponse{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", transactionId='" + transactionId + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", outRefundNo='" + outRefundNo + '\'' +
            ", refundId='" + refundId + '\'' +
            ", refundFee=" + refundFee +
            ", settlementRefundFee=" + settlementRefundFee +
            ", feeType=" + feeType +
            ", cashFee=" + cashFee +
            ", cashRefundFee=" + cashRefundFee +
            ", couponRefundFee=" + couponRefundFee +
            ", couponRefundCount=" + couponRefundCount +
            ", couponType0=" + couponType0 +
            ", couponRefundId0='" + couponRefundId0 + '\'' +
            ", couponRefundFee0=" + couponRefundFee0 +
            "} " + super.toString();
  }
}
