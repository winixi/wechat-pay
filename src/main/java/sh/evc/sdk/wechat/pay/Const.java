package sh.evc.sdk.wechat.pay;

/**
 * 常量
 *
 * @author winixi
 * @date 2018/11/22 11:44 PM
 */
public class Const {

  public static final String SERVER_URL = "https://api.mch.weixin.qq.com";
  public static final String FAIL = "FAIL";
  public static final String SUCCESS = "SUCCESS";

  public static final String FIELD_SIGN = "sign";
  public static final String FIELD_SIGN_TYPE = "sign_type";

  /**
   * time format
   */
  public static final String ORDER_TIME_START = "yyyyMMddHHmmss";
  public static final String ORDER_TIME_EXPIRE = "yyyyMMddHHmmss";
  public static final String ORDER_END_TIME = "yyyyMMddHHmmss";
  public static final String REFUND_SUCCESS_TIME = "yyyy-MM-dd HH:mm:ss";
  public static final String TRANSFER_PAYMENT_TIME = "yyyy-MM-dd HH:mm:ss";

}

