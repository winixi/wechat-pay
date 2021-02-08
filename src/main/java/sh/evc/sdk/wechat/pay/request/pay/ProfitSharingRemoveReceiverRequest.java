package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.domain.ReceiverRemove;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.ProfitSharingRemoveReceiverResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 删除分账接收方
 * https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_4&index=5
 *
 * @author winixi
 * @date 2021/1/28 4:14 PM
 */
public class ProfitSharingRemoveReceiverRequest extends ApiRequest<ProfitSharingRemoveReceiverResponse> {

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
   * 分账接收方对象（不包含分账接收方全称），json格式
   * {"type":"","account":""}
   */
  private ReceiverRemove receiver;

  /**
   * 签名类型，目前只支持HMAC-SHA256
   */
  private SignType signType = SignType.HMACSHA256;

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

  public void setReceiver(ReceiverRemove receiver) {
    this.receiver = receiver;
  }

  /**
   * 必填
   *
   * @param mchId
   * @param appId
   * @param receiver
   */
  public ProfitSharingRemoveReceiverRequest(String mchId, String appId, ReceiverRemove receiver) {
    this.mchId = mchId;
    this.appId = appId;
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
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/profitsharingremovereceiver";
  }

  @Override
  public Class<ProfitSharingRemoveReceiverResponse> getResponseClass() {
    return ProfitSharingRemoveReceiverResponse.class;
  }
}
