package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.OrderQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 订单查询
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
   * 构造
   *
   * @param appId
   * @param subAppId
   * @param mchId
   * @param subMchId
   */
  public OrderQueryRequest(String appId, String mchId, String subMchId) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
  }

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

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("sub_appid", subAppId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("transaction_id", transactionId);
    params.add("out_trade_no", outTradeNo);
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
}
