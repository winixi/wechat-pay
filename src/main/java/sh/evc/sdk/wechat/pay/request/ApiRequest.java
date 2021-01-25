package sh.evc.sdk.wechat.pay.request;

import sh.evc.sdk.wechat.pay.dict.DataType;
import sh.evc.sdk.wechat.pay.dict.RequestMethod;
import sh.evc.sdk.wechat.pay.response.ApiResponse;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;
import sh.evc.sdk.wechat.pay.util.StringUtil;

import java.util.Map;

/**
 * api request
 *
 * @author winixi
 * @date 2021/1/18 10:34 AM
 */
public abstract class ApiRequest<T extends ApiResponse> {

  /**
   * 获取请求参数
   *
   * @return
   */
  public abstract Map<String, String> getRequestParams();

  /**
   * 是否使用证书
   *
   * @return
   */
  public boolean useCert() {
    return false;
  }

  /**
   * 获取接口地址
   *
   * @return
   */
  public abstract String getUri();

  /**
   * 获取请求方法
   *
   * @return
   */
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  /**
   * 接口数据类型
   *
   * @return
   */
  public abstract DataType getDataType();

  /**
   * 获取返回对象类型
   *
   * @return
   */
  public abstract Class<T> getResponseClass();

  /**
   * url拼接所有参数
   *
   * @return
   */
  public String getQueryString() {
    if (getMethod() == RequestMethod.POST) {
      return "";
    }
    Map<String, String> params = getRequestParams();
    if (params == null || params.isEmpty()) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    int i = 0;
    for (String key : params.keySet()) {
      String value = params.get(key);
      if (StringUtil.isEmpty(value)) {
        continue;
      }
      if (i > 0) {
        sb.append("&");
      }
      sb.append(key).append("=").append(params.get(key));
      i++;
    }
    return sb.toString();
  }

  /**
   * json化所有参数
   *
   * @return
   */
  public String getRequestBody() {
    if (this.getMethod() == RequestMethod.GET) {
      return "";
    }
    Map<String, String> params = getRequestParams();
    if (params == null || params.isEmpty()) {
      return "";
    }
    if (getDataType() == DataType.JSON) {
      return SerializeUtil.beanToJson(params);
    } else {
      return SerializeUtil.beanToXml(params);
    }
  }
}
