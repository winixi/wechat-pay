package sh.evc.sdk.wechat.pay.request.risk;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.risk.CertificatesGetResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 证书获取请求
 *
 * @author winixi
 * @date 2021/2/8 3:30 PM
 */
public class CertificatesGetRequest extends ApiRequest<CertificatesGetResponse> {

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 签名方式
   */
  private SignType signType = SignType.HMACSHA256;

  public CertificatesGetRequest(String mchId) {
    this.mchId = mchId;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("sign_type", signType.getValue());
    return params;
  }

  @Override
  public String getUri() {
    return "/risk/getcertficates";
  }

  @Override
  public Class<CertificatesGetResponse> getResponseClass() {
    return CertificatesGetResponse.class;
  }
}
