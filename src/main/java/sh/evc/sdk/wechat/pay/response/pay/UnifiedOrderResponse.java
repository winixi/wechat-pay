package sh.evc.sdk.wechat.pay.response.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 预支付返回
 *
 * @author winixi
 * @date 2021/1/22 9:34 AM
 */
public class UnifiedOrderResponse extends XmlResponse {

  /**
   * 应用ID
   */
  @JsonProperty("appid")
  private String appId;

  /**
   * 子商户应用ID
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
   * 设备号
   */
  private String deviceInfo;

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  /**
   * 业务结果
   */
  private String resultCode;

  /**
   * 错误代码
   */
  private String errCode;

  /**
   * 错误代码描述
   */
  private String errCodeDes;

  /**
   * 交易类型
   */
  private TradeType tradeType;

  /**
   * 预支付编号
   */
  private String prepayId;

  /**
   * 二维码链接
   */
  private String codeUrl;

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

  public String getSubAppId() {
    return subAppId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
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

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  @Override
  public String getResultCode() {
    return resultCode;
  }

  @Override
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  @Override
  public String getErrCode() {
    return errCode;
  }

  @Override
  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  @Override
  public String getErrCodeDes() {
    return errCodeDes;
  }

  @Override
  public void setErrCodeDes(String errCodeDes) {
    this.errCodeDes = errCodeDes;
  }

  public TradeType getTradeType() {
    return tradeType;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public String getPrepayId() {
    return prepayId;
  }

  public void setPrepayId(String prepayId) {
    this.prepayId = prepayId;
  }

  public String getCodeUrl() {
    return codeUrl;
  }

  public void setCodeUrl(String codeUrl) {
    this.codeUrl = codeUrl;
  }

  @Override
  public String toString() {
    return "UnifiedOrderResponse{" +
            "appId='" + appId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", deviceInfo='" + deviceInfo + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", resultCode='" + resultCode + '\'' +
            ", errCode='" + errCode + '\'' +
            ", errCodeDes='" + errCodeDes + '\'' +
            ", tradeType=" + tradeType +
            ", prepayId='" + prepayId + '\'' +
            ", codeUrl='" + codeUrl + '\'' +
            "} " + super.toString();
  }
}
