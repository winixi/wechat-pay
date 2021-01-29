package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.ArchivesModifyResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 修改结算银行卡
 *
 * @author winixi
 * @date 2021/1/29 4:46 PM
 */
public class ArchivesModifyRequest extends ApiRequest<ArchivesModifyResponse> {

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/modifyarchives";
  }

  @Override
  public Class<ArchivesModifyResponse> getResponseClass() {
    return ArchivesModifyResponse.class;
  }
}
