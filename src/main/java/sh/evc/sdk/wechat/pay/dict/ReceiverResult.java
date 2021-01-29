package sh.evc.sdk.wechat.pay.dict;

/**
 * 分账接收结果
 *
 * @author winixi
 * @date 2021/1/28 9:29 AM
 */
public enum ReceiverResult {

  /**
   * 待分账
   */
  PENDING,

  /**
   * 分账成功
   */
  SUCCESS,

  /**
   * 分账失败已关闭
   */
  CLOSED,
}
