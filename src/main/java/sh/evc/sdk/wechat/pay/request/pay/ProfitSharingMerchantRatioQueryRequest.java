package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.ProfitSharingMerchantRatioQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 查询最大分账比例
 *
 * @author winixi
 * @date 2021/1/28 4:20 PM
 */
public class ProfitSharingMerchantRatioQueryRequest extends ApiRequest<ProfitSharingMerchantRatioQueryResponse> {

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 品牌主商户号
   */
  private String brandMchId;

  /**
   * 签名类型，目前只支持HMAC-SHA256
   */
  private SignType signType = SignType.HMACSHA256;

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setBrandMchId(String brandMchId) {
    this.brandMchId = brandMchId;
  }

  public ProfitSharingMerchantRatioQueryRequest(String mchId) {
    this.mchId = mchId;
  }

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("brand_mch_id", brandMchId);
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/profitsharingmerchantratioquery";
  }

  @Override
  public Class<ProfitSharingMerchantRatioQueryResponse> getResponseClass() {
    return ProfitSharingMerchantRatioQueryResponse.class;
  }
}
