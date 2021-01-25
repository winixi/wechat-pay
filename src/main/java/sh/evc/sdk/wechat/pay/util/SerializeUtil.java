package sh.evc.sdk.wechat.pay.util;

import sh.evc.sdk.wechat.pay.util.serialize.JacksonSerialize;
import sh.evc.sdk.wechat.pay.util.serialize.SerializeDelegate;

/**
 * 序列化转换
 *
 * @author winixi
 * @date 2019-02-21 23:03
 */
public class SerializeUtil {

  private final static SerializeDelegate delegate = new JacksonSerialize();

  /**
   * JSON字符串转Bean.
   */
  public static <T> T jsonToBean(String json, Class<T> clazz) {
    return delegate.jsonToBean(json, clazz);
  }

  /**
   * Bean转JSON字符串.
   */
  public static String beanToJson(Object object) {
    return delegate.beanToJson(object);
  }

  /**
   * 将xml转换为对象.
   */
  public static <T> T xmlToBean(String xml, Class<T> clazz) {
    return delegate.xmlToBean(xml, clazz);
  }

  /**
   * 将对象转换为xml.
   */
  public static String beanToXml(Object object) {
    return delegate.beanToXml(object);
  }

}
