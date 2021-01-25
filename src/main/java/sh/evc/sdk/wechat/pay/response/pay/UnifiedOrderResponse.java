package sh.evc.sdk.wechat.pay.response.pay;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 预支付返回
 *
 * @author winixi
 * @date 2021/1/22 9:34 AM
 */
public class UnifiedOrderResponse extends XmlResponse {

  /**
   * 预支付编号
   */
  private String prepayId;

  public String getPrepayId() {
    return prepayId;
  }

  public void setPrepayId(String prepayId) {
    this.prepayId = prepayId;
  }

  @Override
  public String toString() {
    return "PrepayAddResponse{" +
            "prepayId='" + prepayId + '\'' +
            "} " + super.toString();
  }
}
