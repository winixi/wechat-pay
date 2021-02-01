package sh.evc.sdk.wechat.pay.dict;

/**
 * 营业执照类型
 *
 * @author winixi
 * @date 2021/2/1 1:42 PM
 */
public enum BusinessLicenceType {

  /**
   * 三证合一
   */
  NEW("1762"),

  /**
   * 未三证合一
   */
  OLD("1763");

  private String value;

  BusinessLicenceType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
