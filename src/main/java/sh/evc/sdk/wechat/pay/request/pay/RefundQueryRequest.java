package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.RefundQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 查询退款
 * https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_5
 *
 * @author winixi
 * @date 2021/1/27 3:11 PM
 */
public class RefundQueryRequest extends ApiRequest<RefundQueryResponse> {

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
   * 商户退款单号
   */
  private String outRefundNo;

  /**
   * 退款id
   */
  private String refundId;

  /**
   * 偏移量
   * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
   */
  private Integer offset;

  /**
   * 签名类型
   */
  private SignType signType = SignType.MD5;

  /**
   * 服务商子商户查询
   *
   * @param appId
   * @param mchId
   * @param subAppId
   * @param subMchId
   * @param outTradeNo
   * @param outRefundNo
   */
  public RefundQueryRequest(String appId, String mchId, String subAppId, String subMchId, String outTradeNo, String outRefundNo) {
    this.appId = appId;
    this.mchId = mchId;
    this.subAppId = subAppId;
    this.subMchId = subMchId;
    this.outTradeNo = outTradeNo;
    this.outRefundNo = outRefundNo;
  }

  /**
   * 普通商户查询
   *
   * @param appId
   * @param mchId
   * @param outTradeNo
   * @param outRefundNo
   */
  public RefundQueryRequest(String appId, String mchId, String outTradeNo, String outRefundNo) {
    this.appId = appId;
    this.mchId = mchId;
    this.outTradeNo = outTradeNo;
    this.outRefundNo = outRefundNo;
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

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }

  public void setRefundId(String refundId) {
    this.refundId = refundId;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
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
    params.add("out_refund_no", outRefundNo);
    params.add("refund_id", refundId);
    params.add("sign_type", signType.getValue());
    params.add("offset", String.valueOf(offset));
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/refundquery";
  }

  @Override
  public Class<RefundQueryResponse> getResponseClass() {
    return RefundQueryResponse.class;
  }
}
