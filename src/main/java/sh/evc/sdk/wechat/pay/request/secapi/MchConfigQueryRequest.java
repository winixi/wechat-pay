package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.MchConfigQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 配置查询
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=20_4&index=4
 *
 * @author winixi
 * @date 2021/1/29 11:46 AM
 */
public class MchConfigQueryRequest extends ApiRequest<MchConfigQueryResponse> {

  /**
   * 服务商的APPID
   */
  private String appId;

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 必填
   *
   * @param appId
   * @param mchId
   * @param subMchId
   */
  public MchConfigQueryRequest(String appId, String mchId, String subMchId) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
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

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    return params;
  }

  @Override
  public boolean useNonce() {
    return false;
  }

  @Override
  public String getUri() {
    return "/secapi/mch/querysubdevconfig";
  }

  @Override
  public Class<MchConfigQueryResponse> getResponseClass() {
    return MchConfigQueryResponse.class;
  }
}
