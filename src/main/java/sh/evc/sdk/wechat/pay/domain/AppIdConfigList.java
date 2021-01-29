package sh.evc.sdk.wechat.pay.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * appId配置列表
 *
 * @author winixi
 * @date 2021/1/29 11:41 AM
 */
public class AppIdConfigList {

  /**
   * appid配置列表
   */
  @JsonProperty("appid_config_list")
  private ArrayList<AppIdConfig> appIdConfigList;

  public ArrayList<AppIdConfig> getAppIdConfigList() {
    return appIdConfigList;
  }

  public void setAppIdConfigList(ArrayList<AppIdConfig> appIdConfigList) {
    this.appIdConfigList = appIdConfigList;
  }

  @Override
  public String toString() {
    return "AppIdConfigList{" +
            "appIdConfigList=" + appIdConfigList +
            '}';
  }
}
