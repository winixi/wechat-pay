package sh.evc.sdk.wechat.pay.util;

import sh.evc.sdk.wechat.pay.Const;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 *
 * @author winixi
 * @date 2021/1/26 10:21 AM
 */
public class DateUtil {

  private final static SimpleDateFormat sdf = new SimpleDateFormat();

  /**
   * 获取支付开始时间
   *
   * @return
   */
  public static String getPayTimeStart() {
    sdf.applyPattern(Const.PAY_TIME_FORMAT);
    return sdf.format(new Date());
  }

  /**
   * 获取支付失效时间，半个小时
   *
   * @param minute
   * @return
   */
  public static String getPayTimeExpire(int minute) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MINUTE, minute);
    sdf.applyPattern(Const.PAY_TIME_FORMAT);
    return sdf.format(cal.getTime());
  }
}
