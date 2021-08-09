package sh.evc.sdk.wechat.pay;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.config.PayConfig;
import sh.evc.sdk.wechat.pay.config.TestStandardPayConfig;
import sh.evc.sdk.wechat.pay.domain.RefundInfo;
import sh.evc.sdk.wechat.pay.domain.notify.RefundNotify;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;
import sh.evc.sdk.wechat.pay.util.SignatureUtil;

/**
 * @author winixi
 * @date 2021/1/27 3:52 PM
 */
public class RefundNotifyTest {

	private final static Logger log = LoggerFactory.getLogger(RefundNotifyTest.class);
	public PayConfig config = new TestStandardPayConfig();

	@Test
	public void info() throws Exception {
		String xml = "<xml><return_code>SUCCESS</return_code><appid><![CDATA[wxc41ba77c696fb673]]></appid><mch_id><![CDATA[1516531731]]></mch_id><nonce_str><![CDATA[929e789d308b49aed2bed797087ef990]]></nonce_str><req_info><![CDATA[2gNEWxH4qfxNgpNErrzNxM5dHmT4R7MQroGxAMRDyK/JH3v4OcBHyJo9X40V8cbcpvtmK2JuUl9ivlLacAOPkMVcBEgPNkF979Yh4cImigWeuzZpOw7y2FQyrfp8aYm6WmFADyxSrCIug9rPsC/WaVnw2Jn6myMn4b+RYR1oQfcOT9TvTXm5dsF8F5kS5ZNvGaVQIqLBukcdbAnTVatC+VBCN9+gKdA5M4avTZH5W9Oh1P8TF4kj0awWywNBjxaX7CtCEdn55VBrhCfRjjlbzDA9qFF3EuPlRZKaBPOBJ/usba4gxP/FqoirFV+/JkxCnnK2kn/TFZ+vDqTeO/3vMW4QlCnRdXxL+7D0CXxnOKqs/xFjbTCL6uQmNIEVMO0S+yHSXZZfgj/jVf3pFGurDYPut3QexRfoFChUUx8FcfE5uh3c9GQkGNpXkM5Ea99A4fXJgBbnbEobxyJbJhH4rkTw+PRoY4Jq6IjicUISehyUIzastUgAFDs8uVSSwAYjYmeWiOuuQ8MD8idbTv+Ue9KAO0D1Ho2zacER5qMigujabEEPOIrA+qOFTX4nIBGWJ1j0lOpa/Fsv8jw8lO1cfgMEGkEb1Z3Y4V9E2kuxdxeFF5SgGFPtGhxIFcx0mDs/EYsSIGuHPPl86NaQc5oTbWfj9JbsA7Ms0M44fimxzj2PcPsH7NZYdYrlxmGSdkzIZXzM9hNZVqlD7ZW+7XDOiylgp6CLUCNtwsEx8gWQaVJyNZGK5LyCK8CJbBPh3MylEVpfl3J0qrIN1rIf45efmGe8sKUz/J1Hgp3teHNXHEZ+ChV+mRo3yAg9w8yhoi2FF8FegtzJfr9CZk0EamaX9xNBrAmu9pgruD5uCefoFMHUkwNfDCaIysLuU5smyk+Ynp2Y30R8MaTC9+IJ2vcOJ0Ysw43oT/HB6sUld/D9pdRn4HMhaDzM8oRZwZ8EGi1clDJEVDph6VMzyNInScqs2LxLk2O8tApi1T+06Aow6eN8wWQChy2rK4yNJP+8zK96YczzKio5WxFZfyPtT0yIWuZn6L1hNJ04oNk4NoMxAINTloQmTV2YRDaXBwaYfQyK]]></req_info></xml>";
		RefundNotify notify = SerializeUtil.xmlToBean(xml, RefundNotify.class);
		log.info(notify.toString());

		String info = SignatureUtil.reqInfoDecrypt(notify.getReqInfo(), config.getApiKey());
		log.info(info);
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
