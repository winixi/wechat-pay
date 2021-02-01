package sh.evc.sdk.wechat.pay.dict;

/**
 * 经营场景
 *
 * @author winixi
 * @date 2021/2/1 1:53 PM
 */
public enum BusinessScene {

  /**
   * 线下
   */
  OFFLINE("1721");

  private String value;

  BusinessScene(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
