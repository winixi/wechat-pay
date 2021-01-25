package sh.evc.sdk.wechat.pay.dict;

/**
 * 签名类型
 *
 * @author winixi
 * @date 2019-05-23 09:49
 */
public enum SignType {

  MD5("MD5"),
  HMACSHA256("HMAC-SHA256");

  private String name;

  SignType(String name) {
    this.name = name;
  }

  /**
   * 查找
   *
   * @param name
   * @return
   */
  public static SignType find(String name) {
    for (SignType signType : SignType.values()) {
      if (signType.getName().equals(name)) {
        return signType;
      }
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
