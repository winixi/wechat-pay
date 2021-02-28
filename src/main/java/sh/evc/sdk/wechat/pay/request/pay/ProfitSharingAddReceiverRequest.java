package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.domain.ReceiverAdd;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.ProfitSharingAddReceiverResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 添加分账接收方
 * https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_3&index=4
 *
 * @author winixi
 * @date 2021/1/28 4:11 PM
 */
public class ProfitSharingAddReceiverRequest extends ApiRequest<ProfitSharingAddReceiverResponse> {

  /**
   * 商户号
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
   * 子商户公众号id
   */
  private String subAppId;

  /**
   * 分账接收方对象
   * json格式
   */
  private ReceiverAdd receiver;

  /**
   * 签名类型，目前只支持HMAC-SHA256
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填参数
   *
   * @param mchId
   * @param appId
   * @param receiver
   */
  public ProfitSharingAddReceiverRequest(String mchId, String appId, ReceiverAdd receiver) {
    this.mchId = mchId;
    this.appId = appId;
    this.receiver = receiver;
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

  public void setReceiver(ReceiverAdd receiver) {
    this.receiver = receiver;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("brand_mch_id", brandMchId);
    params.add("appid", appId);
    params.add("sub_appid", subAppId);
    params.add("receiver", SerializeUtil.beanToJson(receiver));
    params.add("sign_type", signType.getValue());
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/profitsharingaddreceiver";
  }

  @Override
  public Class<ProfitSharingAddReceiverResponse> getResponseClass() {
    return ProfitSharingAddReceiverResponse.class;
  }
}
