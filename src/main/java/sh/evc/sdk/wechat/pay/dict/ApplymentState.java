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
  AUDITING,

  /**
   * 已驳回
   */
  REJECTED,

  /**
   * 已冻结
   */
  FROZEN,

  /**
   * 待签约
   */
  TO_BE_SIGNED,

  /**
   * 完成
   */
  FINISH,

  /**
   * 资料校验中
   */
  CHECKING,

  /**
   * 待账户验证
   */
  ACCOUNT_NEED_VERIFY,

  /**
   * 待签约
   */
  NEED_SIGN,
}
