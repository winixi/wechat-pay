package sh.evc.sdk.wechat.pay.util;

/**
 * 字符串工具类。
 *
 * @author winixi
 * @date 2021/1/26 10:02 AM
 */
public abstract class StringUtil {

  private StringUtil() {
  }

  /**
   * 检查指定的字符串是否为空。
   * <ul>
   * <li>SysUtils.isEmpty(null) = true</li>
   * <li>SysUtils.isEmpty("") = true</li>
   * <li>SysUtils.isEmpty("   ") = true</li>
   * <li>SysUtils.isEmpty("abc") = false</li>
   * </ul>
   *
   * @param value 待检查的字符串
   * @return true/false
   */
  public static boolean isEmpty(String value) {
    int strLen;
    if (value == null || (strLen = value.length()) == 0) {
      return true;
    }
    for (int i = 0; i < strLen; i++) {
      if ((Character.isWhitespace(value.charAt(i)) == false)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 检查对象是否为数字型字符串,包含负数开头的。
   *
   * @param obj 对象
   * @return 返回
   */
  public static boolean isNumeric(Object obj) {
    if (obj == null) {
      return false;
    }
    char[] chars = obj.toString().toCharArray();
    int length = chars.length;
    if (length < 1)
      return false;

    int i = 0;
    if (length > 1 && chars[0] == '-')
      i = 1;

    for (; i < length; i++) {
      if (!Character.isDigit(chars[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * 检查指定的字符串列表是否不为空。
   *
   * @param values 值
   * @return 返回
   */
  public static boolean areNotEmpty(String... values) {
    boolean result = true;
    if (values == null || values.length == 0) {
      result = false;
    } else {
      for (String value : values) {
        result &= !isEmpty(value);
      }
    }
    return result;
  }

  /**
   * 把通用字符编码的字符串转化为汉字编码。
   *
   * @param unicode 编码
   * @return 返回
   */
  public static String unicodeToChinese(String unicode) {
    StringBuilder out = new StringBuilder();
    if (!isEmpty(unicode)) {
      for (int i = 0; i < unicode.length(); i++) {
        out.append(unicode.charAt(i));
      }
    }
    return out.toString();
  }

  /**
   * 过滤不可见字符
   *
   * @param input 输入
   * @return 返回
   */
  public static String stripNonValidXMLCharacters(String input) {
    if (input == null || ("".equals(input)))
      return "";
    StringBuilder out = new StringBuilder();
    char current;
    for (int i = 0; i < input.length(); i++) {
      current = input.charAt(i);
      if ((current == 0x9) || (current == 0xA) || (current == 0xD)
              || ((current >= 0x20) && (current <= 0xD7FF))
              || ((current >= 0xE000) && (current <= 0xFFFD))
              || ((current >= 0x10000) && (current <= 0x10FFFF)))
        out.append(current);
    }
    return out.toString();
  }

}
