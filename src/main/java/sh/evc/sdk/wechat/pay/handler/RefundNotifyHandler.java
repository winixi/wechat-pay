package sh.evc.sdk.wechat.pay.handler;

import sh.evc.sdk.wechat.pay.domain.RefundInfo;
import sh.evc.sdk.wechat.pay.domain.RefundNotify;

/**
 * 微信退款回调接口
 *
 * @author winixi
 * @date 2018/11/15 10:24 PM
 */
public interface RefundNotifyHandler {

  /**
   * 处理退款对应的业务
   *
   * @param refundNotice
   */
  void process(RefundNotify refundNotify, RefundInfo refundInfo);
}
