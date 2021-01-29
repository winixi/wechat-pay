package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.ContactModifyResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 修改联系人
 *
 * @author winixi
 * @date 2021/1/29 4:44 PM
 */
public class ContactModifyRequest extends ApiRequest<ContactModifyResponse> {

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/modifycontactinfo";
  }

  @Override
  public Class<ContactModifyResponse> getResponseClass() {
    return ContactModifyResponse.class;
  }
}
