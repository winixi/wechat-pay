package sh.evc.sdk.wechat.pay.response.secapi;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 增加jsapi_path配置
 *
 * @author winixi
 * @date 2021/1/29 1:58 PM
 */
public class MchConfigJsapiPathResponse extends XmlResponse {

  /**
   * 签名
   */
  private String sign;

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  @Override
  public String toString() {
    return "MchConfigJsapiPathResponse{" +
            "sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
