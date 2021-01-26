package sh.evc.sdk.wechat.pay;

import org.junit.Before;
import org.junit.Test;
import sh.evc.sdk.wechat.pay.client.PayClient;
import sh.evc.sdk.wechat.pay.config.PayConfig;
import sh.evc.sdk.wechat.pay.config.TestPayConfig;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.handler.TestResponseHandler;
import sh.evc.sdk.wechat.pay.request.pay.UnifiedOrderRequest;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;
import sh.evc.sdk.wechat.pay.util.JsonFormat;
import sh.evc.sdk.wechat.pay.util.NonceStrUtil;

/**
 * @author winixi
 * @date 2021/1/21 4:31 PM
 */
public class PayClientTest extends BaseTest {

  @Test
  public void unifiedOrder() {
    String appId = config.getAppId();
    String mchId = config.getMchId();
    String subMchId = config.getSubMchId();
    String body = "测试支付";
    String outTradeNo = NonceStrUtil.generate();
    int totalFee = 100;
    String spbillCreateIp = "127.0.0.1";
    String notifyUrl = config.getPayNotify();
    UnifiedOrderRequest request = new UnifiedOrderRequest(appId, mchId, subMchId, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, TradeType.JSAPI);
    request.setSubAppId(config.getSubAppId());
    request.setSubOpenId("oGimf4l6H20K00gDjXzr-cJFozP4");
    request.setProfitSharing("Y");

    UnifiedOrderResponse response = client.execute(request);
    JsonFormat.print(response);
  }
}
