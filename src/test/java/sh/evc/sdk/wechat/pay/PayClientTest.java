package sh.evc.sdk.wechat.pay;

import org.junit.Test;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.request.pay.OrderQueryRequest;
import sh.evc.sdk.wechat.pay.request.pay.UnifiedOrderRequest;
import sh.evc.sdk.wechat.pay.response.pay.OrderQueryResponse;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;
import sh.evc.sdk.wechat.pay.util.JsonFormat;
import sh.evc.sdk.wechat.pay.util.NonceStrUtil;

/**
 * @author winixi
 * @date 2021/1/21 4:31 PM
 */
public class PayClientTest extends BaseTest {

  /**
   * 统一下单
   */
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

  /**
   * 订单查询
   */
  @Test
  public void orderQuery() {
    String appId = config.getAppId();
    String mchId = config.getMchId();
    String subMchId = config.getSubMchId();
    OrderQueryRequest request = new OrderQueryRequest(appId, mchId, subMchId);
    request.setSubAppId(config.getSubAppId());
    request.setOutTradeNo("1111111");
    OrderQueryResponse response = client.execute(request);
    JsonFormat.print(response);
  }
}
