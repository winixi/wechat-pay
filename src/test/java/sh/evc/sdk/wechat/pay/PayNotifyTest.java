package sh.evc.sdk.wechat.pay;

import org.junit.Test;
import sh.evc.sdk.wechat.pay.domain.PayNotify;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 支付通知
 *
 * @author winixi
 * @date 2021/1/26 1:43 PM
 */
public class PayNotifyTest extends BaseTest {

  @Test
  public void parse() {
    String xml = "<xml><appid><![CDATA[wxc41ba77c696fb673]]></appid>\n" +
            "<attach><![CDATA[云峦足球场]]></attach>\n" +
            "<bank_type><![CDATA[CCB_CREDIT]]></bank_type>\n" +
            "<cash_fee><![CDATA[2500]]></cash_fee>\n" +
            "<device_info><![CDATA[BOSS207]]></device_info>\n" +
            "<fee_type><![CDATA[CNY]]></fee_type>\n" +
            "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
            "<mch_id><![CDATA[1516531731]]></mch_id>\n" +
            "<nonce_str><![CDATA[PWiQUqI3mQnV4lMXBlj3QI0FLlahDdd4]]></nonce_str>\n" +
            "<openid><![CDATA[oGimf4qeCWxq27fkhLPkyF6fs85M]]></openid>\n" +
            "<out_trade_no><![CDATA[G207U8014P2021012008382933]]></out_trade_no>\n" +
            "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
            "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
            "<sign><![CDATA[F997A5924987BBF1B63E9B46A3944AA17E43DB1A63209909EEBE8E3E86B0644D]]></sign>\n" +
            "<time_end><![CDATA[20210120083837]]></time_end>\n" +
            "<total_fee>2500</total_fee>\n" +
            "<trade_type><![CDATA[JSAPI]]></trade_type>\n" +
            "<transaction_id><![CDATA[4200000845202101207738856295]]></transaction_id>\n" +
            "</xml>";
    PayNotify notify = SerializeUtil.xmlToBean(xml, PayNotify.class);
    log.info(notify.toString());
    log.info(SerializeUtil.beanToXml(notify));

  }
}
