package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.CloseOrderResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 关闭订单
 *
 * @author winixi
 * @date 2021/1/27 1:48 PM
 */
public class CloseOrderRequest extends ApiRequest<CloseOrderResponse> {

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

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  /**
   * 必填
   *
   * @param appId
   * @param mchId
   * @param subMchId
   * @param outTradeNo
   */
  public CloseOrderRequest(String appId, String mchId, String subMchId, String outTradeNo) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.outTradeNo = outTradeNo;
  }

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("sub_appid", subAppId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("out_trade_no", outTradeNo);
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/closeorder";
  }

  @Override
  public Class<CloseOrderResponse> getResponseClass() {
    return CloseOrderResponse.class;
  }
}
