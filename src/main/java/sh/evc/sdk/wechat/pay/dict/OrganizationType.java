package sh.evc.sdk.wechat.pay.dict;

/**
 * 主体类型
 *
 * @author winixi
 * @date 2021/2/1 1:34 PM
 */
public enum OrganizationType {

  /**
   * 企业
   */
  ENTERPRISE("2"),

  /**
   * 个体工商户
   */
  SMALL_BUSINESS("4"),

  /**
   * 其他
   */
  OTHER("1708");

  private String value;

  OrganizationType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
