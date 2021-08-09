package sh.evc.sdk.wechat.pay.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.Const;

import java.text.ParseException;
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

	private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);
	private final static SimpleDateFormat sdf = new SimpleDateFormat();

	/**
	 * 转换订单支付完成时间
	 *
	 * @param endTime
	 * @return
	 */
	public static Date getOrderEndTime(String endTime) {
		sdf.applyPattern(Const.ORDER_END_TIME);
		try {
			return sdf.parse(endTime);
		} catch (ParseException e) {
			logger.error("订单支付完成时间格式转换失败:{}", endTime);
			return null;
		}
	}

	/**
	 * 转化退款成功时间
	 *
	 * @param successTime
	 * @return
	 */
	public static Date getRefundSuccessTime(String successTime) {
		sdf.applyPattern(Const.REFUND_SUCCESS_TIME);
		try {
			return sdf.parse(successTime);
		} catch (ParseException e) {
			logger.error("退款成功时间格式转换失败:{}", successTime);
			return null;
		}
	}

	/**
	 * 转化转账成功时间
	 *
	 * @param paymentTime
	 * @return
	 */
	public static Date getTransferPaymentTime(String paymentTime) {
		sdf.applyPattern(Const.TRANSFER_PAYMENT_TIME);
		try {
			return sdf.parse(paymentTime);
		} catch (ParseException e) {
			logger.error("付款成功时间格式转换失败:{}", paymentTime);
			return null;
		}
	}

	/**
	 * 获取支付开始时间
	 *
	 * @return
	 */
	public static String getPayTimeStart() {
		sdf.applyPattern(Const.ORDER_TIME_START);
		return sdf.format(new Date());
	}

	/**
	 * 获取支付失效时间
	 *
	 * @param minute
	 * @return
	 */
	public static String getPayTimeExpire(int minute) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minute);
		sdf.applyPattern(Const.ORDER_TIME_EXPIRE);
		return sdf.format(cal.getTime());
	}
}
