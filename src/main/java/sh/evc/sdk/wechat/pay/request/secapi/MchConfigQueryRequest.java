package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.MchConfigQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 配置查询
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

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    return params;
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
