package sh.evc.sdk.wechat.pay;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.domain.notify.PayNotify;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 支付通知
 *
 * @author winixi
 * @date 2021/1/26 1:43 PM
 */
public class PayNotifyTest {

  private final static Logger log = LoggerFactory.getLogger(PayNotifyTest.class);

  @Test
  public void parse() {
    String xml = "<xml>\n" +
            "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
            "  <sub_appid>wx2421b1c4370ec13b</sub_appid>\n" +
            "  <attach><![CDATA[支付测试]]></attach>\n" +
            "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
            "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
            "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
            "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
            "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
            "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
            "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
            "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
            "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
            "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
            "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n" +
            "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
            "  <total_fee>1</total_fee>\n" +
            "  <coupon_fee><![CDATA[10]]></coupon_fee>\n" +
            "  <coupon_count><![CDATA[1]]></coupon_count>\n" +
            "  <coupon_type><![CDATA[CASH]]></coupon_type>\n" +
            "  <coupon_id><![CDATA[10000]]></coupon_id>\n" +
            "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
            "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
            "</xml>";
    PayNotify notify = SerializeUtil.xmlToBean(xml, PayNotify.class);
    log.info(notify.toString());
    log.info(SerializeUtil.beanToXml(notify));

  }
}
