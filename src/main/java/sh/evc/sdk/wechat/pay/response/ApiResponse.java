package sh.evc.sdk.wechat.pay.response;

import sh.evc.sdk.wechat.pay.dict.RequestMethod;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

import java.util.Date;
import java.util.Map;

/**
 * api response
 *
 * @author winixi
 * @date 2021/1/18 10:34 AM
 */
public class ApiResponse {

  private String reqUrl;
  private RequestMethod method;
  private Date requestTime;
  private Date responseTime;
  private ParamsMap requestParams;
  private String requestBody;
  private String responseBody;

  public String getReqUrl() {
    return reqUrl;
  }

  public void setReqUrl(String reqUrl) {
    this.reqUrl = reqUrl;
  }

  public RequestMethod getMethod() {
    return method;
  }

  public void setMethod(RequestMethod method) {
    this.method = method;
  }

  public Date getRequestTime() {
    return requestTime;
  }

  public void setRequestTime(Date requestTime) {
    this.requestTime = requestTime;
  }

  public Date getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(Date responseTime) {
    this.responseTime = responseTime;
  }

  public Map<String, String> getRequestParams() {
    return requestParams;
  }

  public void setRequestParams(ParamsMap requestParams) {
    this.requestParams = requestParams;
  }

  public String getRequestBody() {
    return requestBody;
  }

  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  public String getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }

  @Override
  public String toString() {
    return "ApiResponse{" +
            "reqUrl='" + reqUrl + '\'' +
            ", method=" + method +
            ", requestTime=" + requestTime +
            ", responseTime=" + responseTime +
            ", requestParams=" + requestParams +
            ", requestBody=" + requestBody +
            ", responseBody='" + responseBody + '\'' +
            "} " + super.toString();
  }
}
