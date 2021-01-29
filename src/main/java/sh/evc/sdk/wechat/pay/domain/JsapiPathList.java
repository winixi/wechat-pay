package sh.evc.sdk.wechat.pay.domain;

import java.util.List;

/**
 * 授权目录
 *
 * @author winixi
 * @date 2021/1/29 11:43 AM
 */
public class JsapiPathList {

  /**
   * 公众账号JS API支付授权目录列表 ，JSON格式数据，每个支付目录 要求符合URI格式规范，最多返回5个
   */
  private List<String> jsapiPathList;

  public List<String> getJsapiPathList() {
    return jsapiPathList;
  }

  public void setJsapiPathList(List<String> jsapiPathList) {
    this.jsapiPathList = jsapiPathList;
  }

  @Override
  public String toString() {
    return "JsapiPathList{" +
            "jsapiPathList=" + jsapiPathList +
            '}';
  }
}
