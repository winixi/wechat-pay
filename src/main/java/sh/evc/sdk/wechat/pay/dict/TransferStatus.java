package sh.evc.sdk.wechat.pay.dict;

/**
 * 转帐状态
 *
 * @author winixi
 * @date 2021/2/17 10:25 PM
 */
public enum TransferStatus {

  /**
   * 转账成功
   */
  SUCCESS("转账成功"),

  /**
   * 转账失败
   */
  FAILED("转账失败"),

  /**
   * 处理中
   */
  PROCESSING("处理中");

  private String value;

  TransferStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
