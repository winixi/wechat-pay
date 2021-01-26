package sh.evc.sdk.wechat.pay.response.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.dict.FeeType;
import sh.evc.sdk.wechat.pay.dict.TradeState;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.domain.CouponType;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 订单查询
 *
 * @author winixi
 * @date 2021/1/26 4:45 PM
 */
public class OrderQueryResponse extends XmlResponse {

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
   * 设备信息
   */
  private String deviceInfo;

  /**
   * openid
   */
  @JsonProperty("openid")
  private String openId;

  /**
   * 用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）
   */
  private String isSubscribe;

  /**
   * 商户openid
   */
  @JsonProperty("sub_openid")
  private String subOpenId;

  /**
   * 是否关注商户
   */
  private String subIsSubscribe;

  /**
   * 交易类型
   */
  private TradeType tradeType;

  /**
   * 交易状态
   */
  private TradeState tradeState;

  /**
   * 付款银行
   */
  private String bankType;

  /**
   * 商品详情
   */
  private String detail;

  /**
   * 标价金额
   */
  private Integer totalFee;

  /**
   * 标价币种
   */
  private FeeType feeType;

  /**
   * 应结订单金额
   */
  private Integer settlementTotalFee;

  /**
   * 现金支付金额
   */
  private Integer cashFee;

  /**
   * 现金支付货币类型
   */
  private FeeType cashFeeType;

  /**
   * 代金劵金额
   */
  private Integer couponFee;

  /**
   * 代金劵使用数量
   */
  private Integer couponCount;

  /**
   * 代金劵id
   */
  @JsonProperty("coupon_id_1")
  private String couponId1;

  /**
   * 代金劵类型
   */
  @JsonProperty("coupon_type_1")
  private CouponType couponType1;

  /**
   * 代金劵金额
   */
  @JsonProperty("coupon_fee_1")
  private Integer couponFee1;

  /**
   * 微信支付订单号
   */
  private String transactionId;

  /**
   * 商户订单号
   */
  private String outTradeNo;

  /**
   * 商家数据包
   */
  private String attach;

  /**
   * 支付完成时间
   * yyyyMMddHHmmss
   */
  private String timeEnd;

  /**
   * 交易状态描述
   */
  private String tradeStateDesc;

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

  public String getDeviceInfo() {
    return deviceInfo;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getIsSubscribe() {
    return isSubscribe;
  }

  public void setIsSubscribe(String isSubscribe) {
    this.isSubscribe = isSubscribe;
  }

  public String getSubOpenId() {
    return subOpenId;
  }

  public void setSubOpenId(String subOpenId) {
    this.subOpenId = subOpenId;
  }

  public String getSubIsSubscribe() {
    return subIsSubscribe;
  }

  public void setSubIsSubscribe(String subIsSubscribe) {
    this.subIsSubscribe = subIsSubscribe;
  }

  public TradeType getTradeType() {
    return tradeType;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public TradeState getTradeState() {
    return tradeState;
  }

  public void setTradeState(TradeState tradeState) {
    this.tradeState = tradeState;
  }

  public String getBankType() {
    return bankType;
  }

  public void setBankType(String bankType) {
    this.bankType = bankType;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public FeeType getFeeType() {
    return feeType;
  }

  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }

  public Integer getSettlementTotalFee() {
    return settlementTotalFee;
  }

  public void setSettlementTotalFee(Integer settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
  }

  public Integer getCashFee() {
    return cashFee;
  }

  public void setCashFee(Integer cashFee) {
    this.cashFee = cashFee;
  }

  public FeeType getCashFeeType() {
    return cashFeeType;
  }

  public void setCashFeeType(FeeType cashFeeType) {
    this.cashFeeType = cashFeeType;
  }

  public Integer getCouponFee() {
    return couponFee;
  }

  public void setCouponFee(Integer couponFee) {
    this.couponFee = couponFee;
  }

  public Integer getCouponCount() {
    return couponCount;
  }

  public void setCouponCount(Integer couponCount) {
    this.couponCount = couponCount;
  }

  public String getCouponId1() {
    return couponId1;
  }

  public void setCouponId1(String couponId1) {
    this.couponId1 = couponId1;
  }

  public CouponType getCouponType1() {
    return couponType1;
  }

  public void setCouponType1(CouponType couponType1) {
    this.couponType1 = couponType1;
  }

  public Integer getCouponFee1() {
    return couponFee1;
  }

  public void setCouponFee1(Integer couponFee1) {
    this.couponFee1 = couponFee1;
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

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
  }

  public String getTradeStateDesc() {
    return tradeStateDesc;
  }

  public void setTradeStateDesc(String tradeStateDesc) {
    this.tradeStateDesc = tradeStateDesc;
  }

  @Override
  public String toString() {
    return "OrderQueryResponse{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", deviceInfo='" + deviceInfo + '\'' +
            ", openId='" + openId + '\'' +
            ", isSubscribe='" + isSubscribe + '\'' +
            ", subOpenId='" + subOpenId + '\'' +
            ", subIsSubscribe='" + subIsSubscribe + '\'' +
            ", tradeType=" + tradeType +
            ", tradeState=" + tradeState +
            ", bankType='" + bankType + '\'' +
            ", detail='" + detail + '\'' +
            ", totalFee=" + totalFee +
            ", feeType=" + feeType +
            ", settlementTotalFee=" + settlementTotalFee +
            ", cashFee=" + cashFee +
            ", cashFeeType=" + cashFeeType +
            ", couponFee=" + couponFee +
            ", couponCount=" + couponCount +
            ", couponId1='" + couponId1 + '\'' +
            ", couponType1=" + couponType1 +
            ", couponFee1=" + couponFee1 +
            ", transactionId='" + transactionId + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", attach='" + attach + '\'' +
            ", timeEnd='" + timeEnd + '\'' +
            ", tradeStateDesc='" + tradeStateDesc + '\'' +
            "} " + super.toString();
  }
}
