package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.domain.Receiver;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.ProfitSharingResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

import java.util.List;

/**
 * 单次分账请求
 * https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_1&index=1
 *
 * @author winixi
 * @date 2021/1/28 4:06 PM
 */
public class ProfitSharingRequest extends ApiRequest<ProfitSharingResponse> {

  /**
   * 主商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 品牌主商户号
   */
  private String brandMchId;

  /**
   * 公众帐号id
   */
  private String appId;

  /**
   * 子商户公众账号id
   */
  private String subAppId;

  /**
   * 微信支付订单号
   */
  private String transactionId;

  /**
   * 商户分账单号
   */
  private String outOrderNo;

  /**
   * 分账接收方列表
   */
  private List<Receiver> receivers;

  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填
   *
   * @param mchId
   * @param subMchId
   * @param appId
   * @param transactionId
   * @param outOrderNo
   * @param receivers
   */
  public ProfitSharingRequest(String mchId, String subMchId, String appId, String transactionId, String outOrderNo, List<Receiver> receivers) {
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.appId = appId;
    this.transactionId = transactionId;
    this.outOrderNo = outOrderNo;
    this.receivers = receivers;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setBrandMchId(String brandMchId) {
    this.brandMchId = brandMchId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public void setOutOrderNo(String outOrderNo) {
    this.outOrderNo = outOrderNo;
  }

  public void setReceivers(List<Receiver> receivers) {
    this.receivers = receivers;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("brand_mch_id", brandMchId);
    params.add("appid", appId);
    params.add("sub_appid", subAppId);
    params.add("sign_type", signType.getName());
    params.add("transaction_id", transactionId);
    params.add("out_order_no", outOrderNo);
    params.add("receivers", SerializeUtil.beanToJson(receivers));
    return params;
  }

  @Override
  public String getUri() {
    return "/secapi/pay/profitsharing";
  }

  @Override
  public Class<ProfitSharingResponse> getResponseClass() {
    return ProfitSharingResponse.class;
  }
}
