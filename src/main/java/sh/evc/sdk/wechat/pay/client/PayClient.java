package sh.evc.sdk.wechat.pay.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.Const;
import sh.evc.sdk.wechat.pay.config.PayConfig;
import sh.evc.sdk.wechat.pay.dict.DataType;
import sh.evc.sdk.wechat.pay.dict.RequestMethod;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.ApiResponse;
import sh.evc.sdk.wechat.pay.util.*;

import java.io.*;
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
  private byte[] certData;

  public PayClient(PayConfig config, ResponseHandler handler) {
    this.config = config;
    this.handler = handler;
  }

  public PayConfig getConfig() {
    return config;
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
    String url = Const.SERVER_URL + request.getUri();
    DataType dataType = request.getDataType();
    boolean useNonce = request.useNonce();
    ParamsMap basicParams = getBasicParams(request.getSignBasicParams(), request.getUnSignBasicParams(), useNonce);
    String entityData = getEntityData(dataType, request.getEntityParams(), useNonce);
    Date requestTime = new Date();
    File file = request.getFile();
    String res;
    if (request.useCert()) {
      char[] password = config.getMchId().toCharArray();
      InputStream certStream = getCertStream();
      res = this.request.request(method, url, basicParams, entityData, file, password, certStream);
    } else {
      res = this.request.request(method, url, basicParams, entityData, file);
    }

    T response;
    if (dataType == DataType.XML) {
      response = SerializeUtil.xmlToBean(res, request.getResponseClass());
    } else {
      response = SerializeUtil.jsonToBean(res, request.getResponseClass());
    }

    response.setReqUrl(url);
    response.setBasicParams(basicParams);
    response.setEntityData(entityData);
    response.setMethod(request.getMethod());
    response.setRequestTime(requestTime);
    response.setResponseTime(new Date());
    response.setResponseBody(res);

    handler.append(response);
    return response;
  }

  /**
   * 整理params
   *
   * @param signParams
   * @param unSignParams
   * @param useNonce
   * @return
   */
  private ParamsMap getBasicParams(ParamsMap signParams, ParamsMap unSignParams, boolean useNonce) {
    if (signParams == null || signParams.isEmpty()) {
      return null;
    }
    if (useNonce) {
      signParams.put("nonce_str", NonceStrUtil.generate());
    }
    signParams.put("sign", SignatureUtil.generate(signParams, config.getApiKey()));
    if (unSignParams != null) {
      signParams.putAll(unSignParams);
    }
    return signParams;
  }

  /**
   * 整理data
   *
   * @param dataType
   * @param params
   * @param useNonce
   * @return
   */
  private String getEntityData(DataType dataType, ParamsMap params, boolean useNonce) {
    if (params == null || params.isEmpty()) {
      return "";
    }
    if (useNonce) {
      params.put("nonce_str", NonceStrUtil.generate());
    }
    params.put("sign", SignatureUtil.generate(params, config.getApiKey()));
    if (dataType == DataType.JSON) {
      return SerializeUtil.beanToJson(params);
    } else {
      return SerializeUtil.beanToXml(params);
    }
  }
  
  /**
   * 获取商户证书内容
   *
   * @return 商户证书内容
   */
  public InputStream getCertStream() {
    ByteArrayInputStream certBis = null;
    try {
      certBis = new ByteArrayInputStream(getCertData());
    } catch (IOException e) {
      logger.error("无法读取证书文件内容");
    }
    return certBis;
  }

  /**
   * 获取证书内容
   *
   * @return
   * @throws IOException
   */
  public byte[] getCertData() throws IOException {
    if (certData == null) {
      File file = new File(config.getCertPath());
      InputStream certStream = new FileInputStream(file);
      this.certData = new byte[(int) file.length()];
      certStream.read(certData);
      certStream.close();
    }
    return certData;
  }
}
