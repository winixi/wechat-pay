package sh.evc.sdk.wechat.pay.dict;

/**
 * 分账接收方
 *
 * @author winixi
 * @date 2021/1/28 9:19 AM
 */
public enum ReceiverType {

  /**
   * 商户号（mch_id或者sub_mch_id）
   */
  MERCHANT_ID,

  /**
   * 个人openid（由父商户APPID转换得到）
   */
  PERSONAL_OPENID,

  /**
   * 个人sub_openid（由子商户APPID转换得到）
   */
  PERSONAL_SUB_OPENID;
}
