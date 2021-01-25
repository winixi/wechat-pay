package sh.evc.sdk.wechat.pay.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.config.PayConfig;
import sh.evc.sdk.wechat.pay.dict.RequestMethod;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.ApiResponse;
import sh.evc.sdk.wechat.pay.util.ErrorUtil;
import sh.evc.sdk.wechat.pay.util.HttpRequest;
import sh.evc.sdk.wechat.pay.util.JsonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * 支付接口客户端
 *
 * @author winixi
 * @date 2018/5/2 11:20 AM
 */
public class PayClient {

  private final static Logger logger = LoggerFactory.getLogger(PayClient.class);
  private final PayConfig config;
  private final ResponseHandler handler;
  private final HttpRequest request = new HttpRequest();
  private static InputStream certStream = null;

  public PayClient(PayConfig config, ResponseHandler handler) {
    this.config = config;
    this.handler = handler;
  }

  /**
   * 执行请求
   *
   * @param request
   * @param <T>
   * @return
   */
  public <T extends ApiResponse> T execute(ApiRequest<T> request) {
    RequestMethod method = request.getMethod();
    String url = request.getApiModule().getUrl() + request.getUri();
    String body = request.getRequestBody();
    Date requestTime = new Date();
    String res;
    if (request.useCert()) {
      char[] password = config.getMchId().toCharArray();
      InputStream certStream = getCertStream();
      res = this.request.request(method, url, body, null, password, certStream);
    } else {
      res = this.request.request(method, url, body, null);
    }

    T response = JsonUtil.toObject(res, request.getResponseClass());
    response.setReqUrl(url);
    response.setMethod(request.getMethod());
    response.setRequestTime(requestTime);
    response.setResponseTime(new Date());
    response.setRequestBody(body);
    response.setResponseBody(res);

    handler.append(response);
    return response;
  }

  /**
   * 获取证书内容
   *
   * @return
   */
  private InputStream getCertStream() {
    if (certStream == null) {
      File file = new File(config.getCertPath());
      try {
        certStream = new FileInputStream(file);
      } catch (FileNotFoundException e) {
        logger.error("无法读取证书文件{}", ErrorUtil.getStackTraceAsString(e));
      }
    }
    return certStream;
  }

}
