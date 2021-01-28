package sh.evc.sdk.wechat.pay.domain;

import sh.evc.sdk.wechat.pay.dict.ReceiverType;

/**
 * 分账接收方
 *
 * @author winixi
 * @date 2021/1/28 9:21 AM
 */
public class Receiver {

  /**
   * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
   * PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
   * PERSONAL_SUB_OPENID: 个人sub_openid（由子商户APPID转换得到）
   */
  private ReceiverType type;

  /**
   * 类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
   * 类型是PERSONAL_OPENID时，是个人openid
   * 类型是PERSONAL_SUB_OPENID时，是个人sub_openid
   */
  private String account;

  /**
   * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
   */
  private Integer amount;

  /**
   * 分账的原因描述，分账账单中需要体现
   */
  private String description;

  public ReceiverType getType() {
    return type;
  }

  public void setType(ReceiverType type) {
    this.type = type;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Receiver{" +
            "type=" + type +
            ", account='" + account + '\'' +
            ", amount=" + amount +
            ", description='" + description + '\'' +
            '}';
  }
}
