package sh.evc.sdk.wechat.pay.domain;

import sh.evc.sdk.wechat.pay.dict.ReceiverType;

/**
 * 删除接收者
 *
 * @author winixi
 * @date 2021/1/28 5:15 PM
 */
public class ReceiverRemove {

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

  public ReceiverRemove() {
  }

  public ReceiverRemove(ReceiverType type, String account) {
    this.type = type;
    this.account = account;
  }

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

  @Override
  public String toString() {
    return "ReceiverRemove{" +
            "type=" + type +
            ", account='" + account + '\'' +
            '}';
  }
}
