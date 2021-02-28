package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.MchRecommendConfigResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 关注配置
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=20_0&index=1
 *
 * @author winixi
 * @date 2021/1/29 2:13 PM
 */
public class MchRecommendConfigRequest extends ApiRequest<MchRecommendConfigResponse> {

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 小微商户号
   */
  private String subMchId;

  /**
   * 关联appId
   */
  private String subAppId;

  /**
   * 推荐关注appId
   */
  private String subscribeAppId;

  /**
   * 支付凭证推荐小程序appId
   */
  private String receiptAppId;

  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填
   *
   * @param mchId
   * @param subMchId
   * @param receiptAppId
   */
  public MchRecommendConfigRequest(String mchId, String subMchId, String receiptAppId) {
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.receiptAppId = receiptAppId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  public void setSubscribeAppId(String subscribeAppId) {
    this.subscribeAppId = subscribeAppId;
  }

  public void setReceiptAppId(String receiptAppId) {
    this.receiptAppId = receiptAppId;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("sub_appid", subAppId);
    params.add("subscribe_appid", subscribeAppId);
    params.add("receipt_appid", receiptAppId);
    params.add("sign_type", signType.getValue());
    return params;
  }

  @Override
  public String getUri() {
    return "/secapi/mkt/addrecommendconf";
  }

  @Override
  public Class<MchRecommendConfigResponse> getResponseClass() {
    return MchRecommendConfigResponse.class;
  }
}
