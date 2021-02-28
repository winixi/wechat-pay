package sh.evc.sdk.wechat.pay.handler;

import sh.evc.sdk.wechat.pay.domain.PayNotify;

/**
 * 微信支付回调接口
 *
 * @author winixi
 * @date 2018/11/15 10:24 PM
 */
public interface PayNotifyHandler {

  /**
   * 处理订单通知对应的业务
   *
   * @param orderNotice
   */
  void process(PayNotify payNotify);
}
