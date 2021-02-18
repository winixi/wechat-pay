package sh.evc.sdk.wechat.pay.config;

/**
 * config
 *
 * @author winixi
 * @date 2021/1/21 3:30 PM
 */
public interface PayConfig {

  /**
   * 获取主商户应用appid
   *
   * @return
   */
  String getAppId();

  /**
   * 获取api私钥
   *
   * @return
   */
  String getApiKey();

  /**
   * 获取对称加密密钥
   *
   * @return
   */
  String getAesKey();

  /**
   * 获取证书地址
   *
   * @return
   */
  String getCertPath();

  /**
   * 获取主商户号
   *
   * @return
   */
  String getMchId();

  /**
   * 支付通知
   *
   * @return
   */
  String getPayNotify();

  /**
   * 退款通知
   *
   * @return
   */
  String getRefundNotify();

}
