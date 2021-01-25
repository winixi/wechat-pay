package sh.evc.sdk.wechat.pay.domain;

/**
 * 付款通知
 *
 * @author winixi
 * @date 2021/1/22 2:47 PM
 */
public class PayNotify {

  private String appid;
  private String attach;
  private String bankType;
  private String cashFee;
  private String deviceInfo;
  private String feeType;
  private String isSubscribe;
  private String mchId;
  private String nonceStr;
  private String openid;
  private String outTradeNo;
  private String resultCode;
  private String returnCode;
  private String sign;
  private String timeEnd;
  private String totalFee;
  private String tradeType;
  private String transactionId;

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getBankType() {
    return bankType;
  }

  public void setBankType(String bankType) {
    this.bankType = bankType;
  }

  public String getCashFee() {
    return cashFee;
  }

  public void setCashFee(String cashFee) {
    this.cashFee = cashFee;
  }

  public String getDeviceInfo() {
    return deviceInfo;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public String getIsSubscribe() {
    return isSubscribe;
  }

  public void setIsSubscribe(String isSubscribe) {
    this.isSubscribe = isSubscribe;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
  }

  public String getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(String totalFee) {
    this.totalFee = totalFee;
  }

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  @Override
  public String toString() {
    return "PayNotify{" +
            "appid='" + appid + '\'' +
            ", attach='" + attach + '\'' +
            ", bankType='" + bankType + '\'' +
            ", cashFee='" + cashFee + '\'' +
            ", deviceInfo='" + deviceInfo + '\'' +
            ", feeType='" + feeType + '\'' +
            ", isSubscribe='" + isSubscribe + '\'' +
            ", mchId='" + mchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", openid='" + openid + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", resultCode='" + resultCode + '\'' +
            ", returnCode='" + returnCode + '\'' +
            ", sign='" + sign + '\'' +
            ", timeEnd='" + timeEnd + '\'' +
            ", totalFee='" + totalFee + '\'' +
            ", tradeType='" + tradeType + '\'' +
            ", transactionId='" + transactionId + '\'' +
            '}';
  }
}
