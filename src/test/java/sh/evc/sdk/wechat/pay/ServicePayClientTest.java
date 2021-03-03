package sh.evc.sdk.wechat.pay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.client.PayClient;
import sh.evc.sdk.wechat.pay.config.ServicePayConfig;
import sh.evc.sdk.wechat.pay.config.TestServicePayConfig;
import sh.evc.sdk.wechat.pay.dict.ProfitSharing;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.handler.TestResponseHandler;
import sh.evc.sdk.wechat.pay.request.pay.OrderQueryRequest;
import sh.evc.sdk.wechat.pay.request.pay.ProfitSharingMerchantRatioQueryRequest;
import sh.evc.sdk.wechat.pay.request.pay.UnifiedOrderRequest;
import sh.evc.sdk.wechat.pay.request.risk.CertificatesGetRequest;
import sh.evc.sdk.wechat.pay.request.secapi.MchConfigAppIdRequest;
import sh.evc.sdk.wechat.pay.request.secapi.MchRecommendConfigRequest;
import sh.evc.sdk.wechat.pay.request.secapi.MediaUploadRequest;
import sh.evc.sdk.wechat.pay.response.pay.OrderQueryResponse;
import sh.evc.sdk.wechat.pay.response.pay.ProfitSharingMerchantRatioQueryResponse;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;
import sh.evc.sdk.wechat.pay.response.risk.CertificatesGetResponse;
import sh.evc.sdk.wechat.pay.response.secapi.MchConfigAppIdResponse;
import sh.evc.sdk.wechat.pay.response.secapi.MchRecommendConfigResponse;
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

  /**
   * 金盒软件，测试商户
   */
  private String subMchId = "1536473831";

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
    String body = "测试支付";
    String outTradeNo = NonceStrUtil.generate();
    int totalFee = 100;
    String spbillCreateIp = "127.0.0.1";
    String subOpenId = "oGimf4l6H20K00gDjXzr-cJFozP4";
    String subAppId = config.getSubAppId();
    String notifyUrl = config.getPayNotify();
    UnifiedOrderRequest request = new UnifiedOrderRequest(appId, mchId, subAppId, subMchId, subOpenId, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, TradeType.JSAPI);
    request.setProfitSharing(ProfitSharing.Y);

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
    String subAppId = config.getSubAppId();
    String outTradeNo = "1111111";
    OrderQueryRequest request = new OrderQueryRequest(appId, mchId, subAppId, subMchId, outTradeNo);
    OrderQueryResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 查询最大分账比例
   */
  @Test
  public void ProfitSharingMerchantRatioQuery() {
    ProfitSharingMerchantRatioQueryRequest request = new ProfitSharingMerchantRatioQueryRequest(config.getMchId());
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

  /**
   * 这个接口已经无效
   */
  @Test
  public void mchRecommendConfig() {
    String subMchId = "1536473831"; //金盒软件
    String mchId = config.getMchId();
    String subAppId = config.getSubAppId();
    String subscribeAppId = config.getSubscribeAppId();
    MchRecommendConfigRequest request = new MchRecommendConfigRequest(mchId, subAppId, subMchId, subscribeAppId);
    MchRecommendConfigResponse response = client.execute(request);
    if (!response.isSuccess()) {
      log.error("支付后推荐关注配置失败 req:{} resp:{}", request.toString(), response.toString());
      return;
    }
    Assert.assertNotNull(response.toString());
  }

  @Test
  public void mchConfigAppId() {
    String subMchId = "1536473831"; //金盒软件
    String mchId = config.getMchId();
    String appId = config.getAppId();
    String subAppId = config.getSubAppId();
    MchConfigAppIdRequest request = new MchConfigAppIdRequest(appId,  mchId,  subMchId,  subAppId);
    MchConfigAppIdResponse response = client.execute(request);
    if (!response.isSuccess()) {
      log.error("商户号绑定appId失败 req:{} resp:{}", request.toString(), response.toString());
      return;
    }
    Assert.assertNotNull(response.toString());
  }

}
