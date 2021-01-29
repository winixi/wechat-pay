package sh.evc.sdk.wechat.pay.domain;

import sh.evc.sdk.wechat.pay.dict.ReceiverFailReason;
import sh.evc.sdk.wechat.pay.dict.ReceiverResult;
import sh.evc.sdk.wechat.pay.dict.ReceiverType;

/**
 * 分账查询
 *
 * @author winixi
 * @date 2021/1/29 10:11 AM
 */
public class ReceiverQuery {

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
   * 分账金额
   */
  private Integer amount;

  /**
   * 分账描述
   * 分账完结的原因描述，仅当查询分账完结的执行结果时，存在本字段
   */
  private String description;

  /**
   * 分账结果
   */
  private ReceiverResult result;

  /**
   * 分账完成时间
   * 20180608170132
   */
  private String finishTime;

  /**
   * 分账失败原因
   */
  private ReceiverFailReason failReason;

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

  public ReceiverResult getResult() {
    return result;
  }

  public void setResult(ReceiverResult result) {
    this.result = result;
  }

  public String getFinishTime() {
    return finishTime;
  }

  public void setFinishTime(String finishTime) {
    this.finishTime = finishTime;
  }

  public ReceiverFailReason getFailReason() {
    return failReason;
  }

  public void setFailReason(ReceiverFailReason failReason) {
    this.failReason = failReason;
  }

  @Override
  public String toString() {
    return "ReceiverQuery{" +
            "type=" + type +
            ", account='" + account + '\'' +
            ", amount=" + amount +
            ", description='" + description + '\'' +
            ", result=" + result +
            ", finishTime='" + finishTime + '\'' +
            ", failReason=" + failReason +
            '}';
  }
}
