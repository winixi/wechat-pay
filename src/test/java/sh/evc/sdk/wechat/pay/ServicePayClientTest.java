package sh.evc.sdk.wechat.pay;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.client.PayClient;
import sh.evc.sdk.wechat.pay.config.ServicePayConfig;
import sh.evc.sdk.wechat.pay.config.TestServicePayConfig;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.handler.TestResponseHandler;
import sh.evc.sdk.wechat.pay.request.pay.OrderQueryRequest;
import sh.evc.sdk.wechat.pay.request.pay.ProfitSharingMerchantRatioQueryRequest;
import sh.evc.sdk.wechat.pay.request.pay.UnifiedOrderRequest;
import sh.evc.sdk.wechat.pay.request.risk.CertificatesGetRequest;
import sh.evc.sdk.wechat.pay.request.secapi.MediaUploadRequest;
import sh.evc.sdk.wechat.pay.response.pay.OrderQueryResponse;
import sh.evc.sdk.wechat.pay.response.pay.ProfitSharingMerchantRatioQueryResponse;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;
import sh.evc.sdk.wechat.pay.response.risk.CertificatesGetResponse;
import sh.evc.sdk.wechat.pay.response.secapi.MediaUploadResponse;
import sh.evc.sdk.wechat.pay.util.JsonFormat;
import sh.evc.sdk.wechat.pay.util.NonceStrUtil;

import java.io.File;

/**
 * @author winixi
 * @date 2021/1/21 4:31 PM
 */
public class ServicePayClientTest {

  public final static Logger log = LoggerFactory.getLogger(ServicePayClientTest.class);
  public PayClient client;
  public ServicePayConfig config = new TestServicePayConfig();
  public ResponseHandler handler = new TestResponseHandler();

  @Before
  public void before() {
    client = new PayClient(config, handler);
  }

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

  /**
   * 查询最大分账比例
   */
  @Test
  public void ProfitSharingMerchantRatioQuery() {
    ProfitSharingMerchantRatioQueryRequest request = new ProfitSharingMerchantRatioQueryRequest(config.getMchId());
    request.setSubMchId(config.getSubMchId());
    ProfitSharingMerchantRatioQueryResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 获取平台证书
   */
  @Test
  public void CertificatesGet() {
    CertificatesGetRequest request = new CertificatesGetRequest(config.getMchId());
    CertificatesGetResponse response = client.execute(request);
    JsonFormat.print(response.getCertificates().getData()[0]);
  }

  @Test
  public void MediaUpload() {
    String fileName = "media.png";
    String filePath = this.getClass().getClassLoader().getResource(fileName).getFile();
    MediaUploadRequest request = new MediaUploadRequest(config.getMchId(), fileName, new File(filePath));
    MediaUploadResponse response = client.execute(request);
    JsonFormat.print(response);
  }
}
