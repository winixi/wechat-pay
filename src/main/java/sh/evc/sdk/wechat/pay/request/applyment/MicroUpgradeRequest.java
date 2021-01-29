package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.MicroUpgradeResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 小微升级
 *
 * @author winixi
 * @date 2021/1/29 4:49 PM
 */
public class MicroUpgradeRequest extends ApiRequest<MicroUpgradeResponse> {

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/submitupgrade";
  }

  @Override
  public Class<MicroUpgradeResponse> getResponseClass() {
    return MicroUpgradeResponse.class;
  }
}
