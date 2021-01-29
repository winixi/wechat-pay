package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.SubmitStateResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 申请状态查询
 *
 * @author winixi
 * @date 2021/1/29 5:01 PM
 */
public class SubmitStateRequest extends ApiRequest<SubmitStateResponse> {

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/getstate";
  }

  @Override
  public Class<SubmitStateResponse> getResponseClass() {
    return SubmitStateResponse.class;
  }
}
