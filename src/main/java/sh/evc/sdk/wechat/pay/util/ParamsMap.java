package sh.evc.sdk.wechat.pay.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashMap;

/**
 * 参数map
 *
 * @author winixi
 * @date 2021/1/26 10:02 AM
 */
@JacksonXmlRootElement(localName = "xml")
public class ParamsMap extends HashMap<String, String> {

  /**
   * 添加参数
   *
   * @param key
   * @param val
   */
  public void add(String key, String val) {
    if (StringUtil.isEmpty(val)) {
      return;
    }
    super.put(key, val);
  }
}
