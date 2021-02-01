package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.MchConfigAppIdResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 绑定appId配置
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=20_3&index=3
 *
 * @author winixi
 * @date 2021/1/29 1:59 PM
 */
public class MchConfigAppIdRequest extends ApiRequest<MchConfigAppIdResponse> {

  /**
   * 公众账号appId
   */
  private String appId;

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
   * 必填
   *
   * @param appId
   * @param mchId
   * @param subMchId
   * @param subAppId
   */
  public MchConfigAppIdRequest(String appId, String mchId, String subMchId, String subAppId) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.subAppId = subAppId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
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

  @Override
  public boolean useNonce() {
    return false;
  }

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("sub_appid", subAppId);
    return params;
  }

  @Override
  public String getUri() {
    return "/secapi/mch/addsubdevconfig";
  }

  @Override
  public Class<MchConfigAppIdResponse> getResponseClass() {
    return MchConfigAppIdResponse.class;
  }
}
