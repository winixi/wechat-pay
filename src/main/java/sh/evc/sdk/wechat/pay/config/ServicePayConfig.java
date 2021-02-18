package sh.evc.sdk.wechat.pay.config;

/**
 * 服务商
 *
 * @author winixi
 * @date 2021/2/18 9:54 AM
 */
public interface ServicePayConfig extends PayConfig {

  /**
   * 获取特约商户应用appid
   *
   * @return
   */
  String getSubAppId();

  /**
   * 设置特约商户应用appid
   *
   * @param subAppId
   */
  void setSubAppId(String subAppId);

  /**
   * 获取特约商户号
   *
   * @return
   */
  String getSubMchId();

  /**
   * 设置特约商户号
   *
   * @param subMchId
   */
  void setSubMchId(String subMchId);

  /**
   * 分帐通知
   *
   * @return
   */
  String getProfitNotify();

}
