package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.SignType;
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

  /**
   * 版本号
   */
  private String version = "1.0";

  /**
   * 服务商商户号
   */
  private String mchId;

  /**
   * 小微商户号
   */
  private String subMchId;

  /**
   * 签名
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填
   *
   * @param mchId
   * @param subMchId
   */
  public UpgradeStateRequest(String mchId, String subMchId) {
    this.mchId = mchId;
    this.subMchId = subMchId;
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
    params.add("version", version);
    params.add("mchId", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("sign_type", signType.getName());
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
