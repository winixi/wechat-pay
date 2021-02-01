package sh.evc.sdk.wechat.pay.response.applyment;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 小微商户升级返回
 *
 * @author winixi
 * @date 2021/1/29 4:49 PM
 */
public class MicroUpgradeResponse extends XmlResponse {

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  @Override
  public String toString() {
    return "MicroUpgradeResponse{" +
            "nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
