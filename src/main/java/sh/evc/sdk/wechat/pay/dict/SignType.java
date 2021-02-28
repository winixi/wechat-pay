package sh.evc.sdk.wechat.pay.dict;

/**
 * 签名类型
 *
 * @author winixi
 * @date 2019-05-23 09:49
 */
public enum SignType {

  /**
   * md5
   */
  MD5("MD5"),

  /**
   * sha256
   */
  HMACSHA256("HMAC-SHA256");

  private String value;

  SignType(String value) {
    this.value = value;
  }

  /**
   * 查找
   *
   * @param name
   * @return
   */
  public static SignType getByValue(String name) {
    for (SignType signType : SignType.values()) {
      if (signType.getValue().equals(name)) {
        return signType;
      }
    }
    return null;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
