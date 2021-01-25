package sh.evc.sdk.wechat.pay.domain;

/**
 * 场景信息
 *
 * @author winixi
 * @date 2021/1/25 7:58 PM
 */
public class SceneInfo {

  /**
   * 门店id
   */
  private String id;

  /**
   * 门店名称
   */
  private String name;

  /**
   * 门店行政区划
   */
  private String areaCode;

  /**
   * 门店地址
   */
  private String address;

  public SceneInfo() {
  }

  public SceneInfo(String id, String name, String areaCode, String address) {
    this.id = id;
    this.name = name;
    this.areaCode = areaCode;
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "SceneInfo{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", areaCode='" + areaCode + '\'' +
            ", address='" + address + '\'' +
            '}';
  }
}
