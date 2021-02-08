package sh.evc.sdk.wechat.pay.request;

import sh.evc.sdk.wechat.pay.dict.DataType;
import sh.evc.sdk.wechat.pay.dict.RequestMethod;
import sh.evc.sdk.wechat.pay.response.ApiResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.StringUtil;

import java.io.File;

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
  public abstract ParamsMap getEntityParams();

  /**
   * 获取基本请求参数
   *
   * @return
   */
  public ParamsMap getBasicParams() {
    return null;
  }

  /**
   * 获取不签名的请求参数
   *
   * @return
   */
  public ParamsMap getBasicUnSignParams() {
    return null;
  }

  /**
   * 是否使用证书
   *
   * @return
   */
  public boolean useCert() {
    return false;
  }

  /**
   * 使用nonceStr
   *
   * @return
   */
  public boolean useNonce() {
    return true;
  }

  /**
   * 获取接口地址
   *
   * @return
   */
  public abstract String getUri();

  /**
   * 获取文件
   *
   * @return
   */
  public File getFile() {
    return null;
  }

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
  public DataType getDataType() {
    return DataType.XML;
  }

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
    ParamsMap params = getEntityParams();
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

}
