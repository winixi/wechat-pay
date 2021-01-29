package sh.evc.sdk.wechat.pay.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * appId配置
 *
 * @author winixi
 * @date 2021/1/29 11:37 AM
 */
public class AppIdConfig {

  /**
   * 关注公众号的APPID；
   * 配置关系如果绑定多个以列表形式返回
   */
  @JsonProperty("subscribe_appid")
  private String subscribeAppId;

  /**
   * 为绑定好的商户公众号、小程序、APP支付等APPID；
   */
  @JsonProperty("sub_appid")
  private String subAppId;

  public String getSubscribeAppId() {
    return subscribeAppId;
  }

  public void setSubscribeAppId(String subscribeAppId) {
    this.subscribeAppId = subscribeAppId;
  }

  public String getSubAppId() {
    return subAppId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  @Override
  public String toString() {
    return "AppIdConfig{" +
            "subscribeAppId='" + subscribeAppId + '\'' +
            ", subAppId='" + subAppId + '\'' +
            '}';
  }
}
