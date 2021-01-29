package sh.evc.sdk.wechat.pay.response.secapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import sh.evc.sdk.wechat.pay.domain.AppIdConfigList;
import sh.evc.sdk.wechat.pay.domain.JsapiPathList;
import sh.evc.sdk.wechat.pay.response.XmlResponse;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 商户配置查询
 *
 * @author winixi
 * @date 2021/1/29 11:33 AM
 */
public class MchConfigQueryResponse extends XmlResponse {

  /**
   * 授权目录
   * 公众账号JS API支付授权目录列表 ，JSON格式数据，每个支付目录 要求符合URI格式规范，最多返回5个
   */
  private String jsapiPathList;

  /**
   * 关联APPID与关注
   * sub_appid为绑定好的商户公众号、小程序、APP支付等APPID；
   * subscribe_appid关注公众号的APPID；
   * 配置关系如果绑定多个以列表形式返回，如果不区分绑定则sub_appid=NULL的记录返回默认推荐关注的APPID
   */
  @JsonProperty("appid_config_list")
  private String appIdConfigList;

  /**
   * 签名
   */
  private String sign;

  public JsapiPathList getJsapiPathList() {
    return SerializeUtil.jsonToBean(jsapiPathList, JsapiPathList.class);
  }

  public void setJsapiPathList(String jsapiPathList) {
    this.jsapiPathList = jsapiPathList;
  }

  public AppIdConfigList getAppIdConfigList() {
    return SerializeUtil.jsonToBean(appIdConfigList, AppIdConfigList.class);
  }

  public void setAppIdConfigList(String appIdConfigList) {
    this.appIdConfigList = appIdConfigList;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  @Override
  public String toString() {
    return "MchConfigQueryResponse{" +
            "jsapiPathList='" + jsapiPathList + '\'' +
            ", appIdConfigList='" + appIdConfigList + '\'' +
            ", sign='" + sign + '\'' +
            '}';
  }
}
