package sh.evc.sdk.wechat.pay.dict;

/**
 * 退款渠道
 *
 * @author winixi
 * @date 2021/3/1 1:46 PM
 */
public enum RefundChannel {

  /**
   * 原路退回
   */
  ORIGINAL,

  /**
   * 退回到余额
   */
  BALANCE,

  /**
   * 原账户异常退到其他余额账户
   */
  OTHER_BALANCE,

  /**
   * 原银行卡异常退到其他银行卡
   */
  OTHER_BANKCARD,
}
