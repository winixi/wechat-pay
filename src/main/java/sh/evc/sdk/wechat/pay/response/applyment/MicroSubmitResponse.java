package sh.evc.sdk.wechat.pay.response.applyment;

import sh.evc.sdk.wechat.pay.response.ApiResponse;

/**
 * 小微商户入驻
 *
 * @author winixi
 * @date 2021/1/21 3:44 PM
 */
public class MicroSubmitResponse extends ApiResponse {

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  /**
   * 商户申请单号
   */
  private String applymentId;

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

  public String getApplymentId() {
    return applymentId;
  }

  public void setApplymentId(String applymentId) {
    this.applymentId = applymentId;
  }

  @Override
  public String toString() {
    return "MicroSubmitResponse{" +
            "nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", applymentId='" + applymentId + '\'' +
            "} " + super.toString();
  }
}
