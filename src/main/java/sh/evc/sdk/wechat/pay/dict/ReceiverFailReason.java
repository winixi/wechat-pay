package sh.evc.sdk.wechat.pay.dict;

/**
 * 分账失败原因
 *
 * @author winixi
 * @date 2021/1/28 9:31 AM
 */
public enum ReceiverFailReason {

  /**
   * 分账接收账户异常
   */
  ACCOUNT_ABNORMAL,

  /**
   * 分账关系已解除
   */
  NO_RELATION,

  /**
   * 高风险接收方
   */
  RECEIVER_HIGH_RISK,
}
