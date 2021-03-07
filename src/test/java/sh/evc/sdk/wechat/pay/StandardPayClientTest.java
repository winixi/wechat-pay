package sh.evc.sdk.wechat.pay;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.client.PayClient;
import sh.evc.sdk.wechat.pay.config.StandardPayConfig;
import sh.evc.sdk.wechat.pay.config.TestStandardPayConfig;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.handler.TestResponseHandler;
import sh.evc.sdk.wechat.pay.request.pay.RefundQueryRequest;
import sh.evc.sdk.wechat.pay.request.pay.UnifiedOrderRequest;
import sh.evc.sdk.wechat.pay.response.pay.RefundQueryResponse;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;
import sh.evc.sdk.wechat.pay.util.JsonFormat;
import sh.evc.sdk.wechat.pay.util.NonceStrUtil;

/**
 * @author winixi
 * @date 2021/1/21 4:31 PM
 */
public class StandardPayClientTest {

  public final static Logger log = LoggerFactory.getLogger(StandardPayClientTest.class);
  public PayClient client;
  public StandardPayConfig config = new TestStandardPayConfig();
  public ResponseHandler handler = new TestResponseHandler();

  @Before
  public void before() {
    client = new PayClient(config, handler);
  }

  /**
   * 测试普通商户付款
   */
  @Test
  public void unifiedOrder() {
    String appId = config.getAppId();
    String mchId = config.getMchId();
    String body = "测试支付";
    String outTradeNo = NonceStrUtil.generate();
    int totalFee = 100;
    String spbillCreateIp = "127.0.0.1";
    String openId = "oGimf4l6H20K00gDjXzr-cJFozP4";
    String notifyUrl = config.getPayNotify();
    UnifiedOrderRequest request = new UnifiedOrderRequest(appId, mchId, openId, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, TradeType.JSAPI);

    UnifiedOrderResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  @Test
  public void refundQuery() {
    String appId = config.getAppId();
    String mchId = config.getMchId();
    String outRefundNo = "G1U1R20190516230053665";
    RefundQueryRequest request = new RefundQueryRequest(appId, mchId, outRefundNo);
    RefundQueryResponse response = client.execute(request);
    JsonFormat.print(response);
  }

}
