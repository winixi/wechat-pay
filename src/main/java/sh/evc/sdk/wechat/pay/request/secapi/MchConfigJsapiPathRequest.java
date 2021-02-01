package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.MchConfigJsapiPathResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 增加支付目录配置
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=20_2&index=2
 *
 * @author winixi
 * @date 2021/1/29 1:59 PM
 */
public class MchConfigJsapiPathRequest extends ApiRequest<MchConfigJsapiPathResponse> {

  /**
   * 公众账号appId
   */
  private String appId;

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 小微商户号
   */
  private String subMchId;

  /**
   * 授权目录
   */
  private String jsapiPath;

  /**
   * 必填
   *
   * @param appId
   * @param mchId
   * @param subMchId
   * @param jsapiPath
   */
  public MchConfigJsapiPathRequest(String appId, String mchId, String subMchId, String jsapiPath) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.jsapiPath = jsapiPath;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setJsapiPath(String jsapiPath) {
    this.jsapiPath = jsapiPath;
  }

  @Override
  public boolean useNonce() {
    return false;
  }

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("jsapi_path", jsapiPath);
    return params;
  }

  @Override
  public String getUri() {
    return "/secapi/mch/addsubdevconfig";
  }

  @Override
  public Class<MchConfigJsapiPathResponse> getResponseClass() {
    return MchConfigJsapiPathResponse.class;
  }
}
