package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.SubmitStateResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 查询申请状态
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=19_3
 *
 * @author winixi
 * @date 2021/1/29 5:01 PM
 */
public class SubmitStateRequest extends ApiRequest<SubmitStateResponse> {

  /**
   * 版本号
   */
  private String version = "1.0";

  /**
   * 服务商商户号
   */
  private String mchId;

  /**
   * 商户申请单号
   */
  private String applymentId;

  /**
   * 业务申请编号
   * 服务商自定义的商户唯一编号。当applyment_id已填写时，此字段无效。
   */
  private String businessCode;

  /**
   * 签名
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 构造
   *
   * @param mchId
   * @param businessCode
   */
  public SubmitStateRequest(String mchId, String businessCode) {
    this.mchId = mchId;
    this.businessCode = businessCode;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setApplymentId(String applymentId) {
    this.applymentId = applymentId;
  }

  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("version", version);
    params.add("mchId", mchId);
    params.add("applyment_id", applymentId);
    params.add("business_code", businessCode);
    params.add("sign_type", signType.getValue());
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

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getMchId() {
    return mchId;
  }

  public String getApplymentId() {
    return applymentId;
  }

  public String getBusinessCode() {
    return businessCode;
  }

  public SignType getSignType() {
    return signType;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  @Override
  public String toString() {
    return "SubmitStateRequest{" +
            "version='" + version + '\'' +
            ", mchId='" + mchId + '\'' +
            ", applymentId='" + applymentId + '\'' +
            ", businessCode='" + businessCode + '\'' +
            ", signType=" + signType +
            "} " + super.toString();
  }
}
