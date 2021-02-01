package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.ProfitSharingQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 分账查询请求
 * https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_2&index=3
 *
 * @author winixi
 * @date 2021/1/28 4:08 PM
 */
public class ProfitSharingQueryRequest extends ApiRequest<ProfitSharingQueryResponse> {

  /**
   * 服务商的appid
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
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填
   *
   * @param appId
   * @param subAppId
   * @param mchId
   * @param subMchId
   * @param transactionId
   * @param outTradeNo
   */
  public ProfitSharingQueryRequest(String appId, String subAppId, String mchId, String subMchId, String transactionId, String outTradeNo) {
    this.appId = appId;
    this.subAppId = subAppId;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.transactionId = transactionId;
    this.outTradeNo = outTradeNo;
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
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/profitsharingquery";
  }

  @Override
  public Class<ProfitSharingQueryResponse> getResponseClass() {
    return ProfitSharingQueryResponse.class;
  }
}
