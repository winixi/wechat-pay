package sh.evc.sdk.wechat.pay.response.secapi;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 关注配置
 *
 * @author winixi
 * @date 2021/1/29 11:33 AM
 */
public class MchRecommendConfigResponse extends XmlResponse {

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
    return "MchRecommendConfigResponse{" +
            "sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
