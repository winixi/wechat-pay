package sh.evc.sdk.wechat.pay.dict;

/**
 * 支付交易类型
 *
 * @author winixi
 * @date 2021/1/25 7:54 PM
 */
public enum TradeType {

  /**
   * jsapi或小程序支付
   */
  JSAPI,

  /**
   * native支付
   */
  NATIVE,

  /**
   * app支付
   */
  APP,

  /**
   * H5支付
   */
  MWEB,

  /**
   * 付款码支付，付款码支付有单独的支付接口，所以接口不需要上传，该字段在对账单中会出现
   */
  MICROPAY;
}
