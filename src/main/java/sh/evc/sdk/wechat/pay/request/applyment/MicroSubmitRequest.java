package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.DataType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.MicroSubmitResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 小微商户入驻
 *
 * @author winixi
 * @date 2021/1/21 3:44 PM
 */
public class MicroSubmitRequest extends ApiRequest<MicroSubmitResponse> {

  @Override
  public ParamsMap getRequestParams() {
    return null;
  }

  @Override
  public String getUri() {
    return null;
  }

  @Override
  public DataType getDataType() {
    return null;
  }

  @Override
  public Class<MicroSubmitResponse> getResponseClass() {
    return null;
  }
}

