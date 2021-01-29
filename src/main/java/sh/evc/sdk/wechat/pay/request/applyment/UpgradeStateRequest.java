package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.UpgradeStateResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 升级状态查询
 *
 * @author winixi
 * @date 2021/1/29 4:57 PM
 */
public class UpgradeStateRequest extends ApiRequest<UpgradeStateResponse> {

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/getupgradestate";
  }

  @Override
  public Class<UpgradeStateResponse> getResponseClass() {
    return UpgradeStateResponse.class;
  }
}
