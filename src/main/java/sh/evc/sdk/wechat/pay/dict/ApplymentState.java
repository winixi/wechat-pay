package sh.evc.sdk.wechat.pay.dict;

/**
 * 申请状态
 *
 * @author winixi
 * @date 2021/1/31 3:00 PM
 */
public enum ApplymentState {

  /**
   * 审核中
   */
  AUDITING("审核中"),

  /**
   * 已驳回
   */
  REJECTED("已驳回"),

  /**
   * 已冻结
   */
  FROZEN("已冻结"),

  /**
   * 待签约
   */
  TO_BE_SIGNED("待签约"),

  /**
   * 完成
   */
  FINISH("完成"),

  /**
   * 资料校验中
   */
  CHECKING("资料校验中"),

  /**
   * 待账户验证
   */
  ACCOUNT_NEED_VERIFY("待账户验证"),

  /**
   * 待签约
   */
  NEED_SIGN("待签约");

  private String value;

  ApplymentState(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
