package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.ProfitSharingResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 单次分账请求
 *
 * @author winixi
 * @date 2021/1/28 4:06 PM
 */
public class ProfitSharingRequest extends ApiRequest<ProfitSharingResponse> {

  @Override
  public ParamsMap getRequestParams() {
    return null;
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
