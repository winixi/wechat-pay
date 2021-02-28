package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.OrderQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 查询订单
 * https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_2
 *
 * @author winixi
 * @date 2021/1/26 4:45 PM
 */
public class OrderQueryRequest extends ApiRequest<OrderQueryResponse> {

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
   * 微信订单号
   */
  private String transactionId;

  /**
   * 商户订单号
   */
  private String outTradeNo;

  /**
   * 签名类型
   */
  private SignType signType = SignType.MD5;

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  public String getAppId() {
    return appId;
  }

  public String getSubAppId() {
    return subAppId;
  }

  public String getMchId() {
    return mchId;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public SignType getSignType() {
    return signType;
  }

  /**
   * 服务商查询
   *
   * @param appId
   * @param mchId
   * @param subAppId
   * @param subMchId
   * @param outTradeNo
   */
  public OrderQueryRequest(String appId, String mchId, String subAppId, String subMchId, String outTradeNo) {
    this.appId = appId;
    this.mchId = mchId;
    this.subAppId = subAppId;
    this.subMchId = subMchId;
    this.outTradeNo = outTradeNo;
  }

  /**
   * 普通商户查询
   *
   * @param appId
   * @param mchId
   * @param outTradeNo
   */
  public OrderQueryRequest(String appId, String mchId, String outTradeNo) {
    this.appId = appId;
    this.mchId = mchId;
    this.outTradeNo = outTradeNo;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("sub_appid", subAppId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("transaction_id", transactionId);
    params.add("out_trade_no", outTradeNo);
    params.add("sign_type", signType.getValue());
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/orderquery";
  }

  @Override
  public Class<OrderQueryResponse> getResponseClass() {
    return OrderQueryResponse.class;
  }

  @Override
  public String toString() {
    return "OrderQueryRequest{" +
            "appId='" + appId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", transactionId='" + transactionId + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", signType=" + signType +
            "} " + super.toString();
  }
}
