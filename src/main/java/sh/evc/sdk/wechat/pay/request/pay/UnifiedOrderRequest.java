package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.ApiModule;
import sh.evc.sdk.wechat.pay.dict.DataType;
import sh.evc.sdk.wechat.pay.dict.RequestMethod;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;

import java.util.Map;

/**
 * 生成预支付订单
 *
 * @author winixi
 * @date 2021/1/22 9:37 AM
 */
public class UnifiedOrderRequest extends ApiRequest<UnifiedOrderResponse> {

  @Override
  public Map<String, String> getRequestParams() {
    return null;
  }

  @Override
  public String getUri() {
    return "/pay/unifiedorder";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public ApiModule getApiModule() {
    return ApiModule.JSAPI;
  }

  @Override
  public DataType getDataType() {
    return DataType.JSON;
  }

  @Override
  public Class<UnifiedOrderResponse> getResponseClass() {
    return UnifiedOrderResponse.class;
  }
}
