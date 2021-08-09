package sh.evc.sdk.wechat.pay.domain.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import sh.evc.sdk.wechat.pay.dict.CouponType;
import sh.evc.sdk.wechat.pay.dict.FeeType;
import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 付款通知
 *
 * @author winixi
 * @date 2021/1/22 2:47 PM
 */
@JacksonXmlRootElement(localName = "xml")
public class PayNotify extends XmlResponse {

  /**
   * 服务商的appId
   */
  @JsonProperty("appid")
  private String appId;

  /**
   * 子商户公众账号id
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
   * 签名方式
   */
  private SignType signType;

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
  @JsonProperty("coupon_id_0")
  private String couponId0;

  /**
   * 代金劵类型
   */
  @JsonProperty("coupon_type_0")
  private CouponType couponType0;

  /**
   * 代金劵金额
   */
  @JsonProperty("coupon_fee_0")
  private Integer couponFee0;

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

  public String getCouponId0() {
    return couponId0;
  }

  public void setCouponId0(String couponId0) {
    this.couponId0 = couponId0;
  }

  public CouponType getCouponType0() {
    return couponType0;
  }

  public void setCouponType0(CouponType couponType0) {
    this.couponType0 = couponType0;
  }

  public Integer getCouponFee0() {
    return couponFee0;
  }

  public void setCouponFee0(Integer couponFee0) {
    this.couponFee0 = couponFee0;
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

  public SignType getSignType() {
    return signType;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  @Override
  public String toString() {
    return "PayNotify{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", signType=" + signType +
            ", deviceInfo='" + deviceInfo + '\'' +
            ", openId='" + openId + '\'' +
            ", isSubscribe='" + isSubscribe + '\'' +
            ", subOpenId='" + subOpenId + '\'' +
            ", subIsSubscribe='" + subIsSubscribe + '\'' +
            ", tradeType=" + tradeType +
            ", bankType='" + bankType + '\'' +
            ", detail='" + detail + '\'' +
            ", totalFee=" + totalFee +
            ", feeType=" + feeType +
            ", settlementTotalFee=" + settlementTotalFee +
            ", cashFee=" + cashFee +
            ", cashFeeType=" + cashFeeType +
            ", couponFee=" + couponFee +
            ", couponCount=" + couponCount +
            ", couponId0='" + couponId0 + '\'' +
            ", couponType0=" + couponType0 +
            ", couponFee0=" + couponFee0 +
            ", transactionId='" + transactionId + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", attach='" + attach + '\'' +
            ", timeEnd='" + timeEnd + '\'' +
            "} " + super.toString();
  }
}
