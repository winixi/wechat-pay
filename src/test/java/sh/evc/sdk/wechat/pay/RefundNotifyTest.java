package sh.evc.sdk.wechat.pay;

import org.junit.Test;
import sh.evc.sdk.wechat.pay.domain.RefundInfo;
import sh.evc.sdk.wechat.pay.notify.RefundNotify;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * @author winixi
 * @date 2021/1/27 3:52 PM
 */
public class RefundNotifyTest extends BaseTest {

  @Test
  public void info() {
    String xml = "<xml>\n" +
            "\n" +
            "   <return_code>SUCCESS</return_code>\n" +
            "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
            "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
            "   <nonce_str><![CDATA[TeqClE3i0mvn3DrK]]></nonce_str>\n" +
            "   <req_info><![CDATA[T87GAHG17TGAHG1TGHAHAHA1Y1CIOA9UGJH1GAHV871HAGAGQYQQPOOJMXNBCXBVNMNMAJAA]]></req_info>\n" +
            "</xml>";
    RefundNotify notify = SerializeUtil.xmlToBean(xml, RefundNotify.class);
    log.info(notify.toString());
  }

  @Test
  public void req() {
    String xml = "<root>\n" +
            "<out_refund_no><![CDATA[131811191610442717309]]></out_refund_no>\n" +
            "<out_trade_no><![CDATA[71106718111915575302817]]></out_trade_no>\n" +
            "<refund_account><![CDATA[REFUND_SOURCE_RECHARGE_FUNDS]]></refund_account>\n" +
            "<refund_fee><![CDATA[3960]]></refund_fee>\n" +
            "<refund_id><![CDATA[50000408942018111907145868882]]></refund_id>\n" +
            "<refund_recv_accout><![CDATA[支付用户零钱]]></refund_recv_accout>\n" +
            "<refund_request_source><![CDATA[API]]></refund_request_source>\n" +
            "<refund_status><![CDATA[SUCCESS]]></refund_status>\n" +
            "<settlement_refund_fee><![CDATA[3960]]></settlement_refund_fee>\n" +
            "<settlement_total_fee><![CDATA[3960]]></settlement_total_fee>\n" +
            "<success_time><![CDATA[2018-11-19 16:24:13]]></success_time>\n" +
            "<total_fee><![CDATA[3960]]></total_fee>\n" +
            "<transaction_id><![CDATA[4200000215201811190261405420]]></transaction_id>\n" +
            "</root>";
    RefundInfo info = SerializeUtil.xmlToBean(xml, RefundInfo.class);
    log.info(info.toString());
  }
}
