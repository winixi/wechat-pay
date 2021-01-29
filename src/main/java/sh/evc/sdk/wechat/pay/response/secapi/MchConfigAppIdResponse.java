package sh.evc.sdk.wechat.pay.response.secapi;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 绑定appId配置
 *
 * @author winixi
 * @date 2021/1/29 1:58 PM
 */
public class MchConfigAppIdResponse extends XmlResponse {

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
    return "MchConfigAppIdResponse{" +
            "sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
