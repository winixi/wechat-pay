package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.dict.FeeType;
import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.RefundResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 申请退款
 * https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_4
 *
 * @author winixi
 * @date 2021/1/27 2:45 PM
 */
public class RefundRequest extends ApiRequest<RefundResponse> {

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
   * 订单金额
   */
  private Integer totalFee;

  /**
   * 退款金额
   */
  private Integer refundFee;

  /**
   * 货币类型
   */
  private FeeType refundFeeType;

  /**
   * 退款原因
   */
  private String refundDesc;

  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 通知地址
   */
  private String notifyUrl;

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

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public void setRefundFee(Integer refundFee) {
    this.refundFee = refundFee;
  }

  public void setRefundFeeType(FeeType refundFeeType) {
    this.refundFeeType = refundFeeType;
  }

  public void setRefundDesc(String refundDesc) {
    this.refundDesc = refundDesc;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  /**
   * 必填
   *
   * @param appId
   * @param mchId
   * @param subMchId
   * @param outRefundNo
   * @param totalFee
   * @param refundFee
   */
  public RefundRequest(String appId, String mchId, String subMchId, String outRefundNo, Integer totalFee, Integer refundFee) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.outRefundNo = outRefundNo;
    this.totalFee = totalFee;
    this.refundFee = refundFee;
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
    params.add("sign_type", signType.getName());
    params.add("out_refund_no", outRefundNo);
    params.add("total_fee", String.valueOf(totalFee));
    params.add("refund_fee", String.valueOf(refundFee));
    params.add("refund_fee_type", refundFeeType.name());
    params.add("refund_desc", refundDesc);
    params.add("notify_url", notifyUrl);
    return params;
  }

  @Override
  public String getUri() {
    return "/secapi/pay/refund";
  }

  @Override
  public Class<RefundResponse> getResponseClass() {
    return RefundResponse.class;
  }
}
