package sh.evc.sdk.wechat.pay.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64 for iso-8859
 *
 * @author winixi
 * @date 2019-07-06 22:54
 */
public class Base64Util {

  /**
   * 解码
   *
   * @param source
   * @return
   */
  public static String decode8859(final String source) {
    String result = "";
    final Base64.Decoder decoder = Base64.getDecoder();
    try {
      result = new String(decoder.decode(source), "ISO-8859-1");
      //此处的字符集是ISO-8859-1
    } catch (final UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * 编码
   *
   * @param source
   * @return
   */
  public static String encode8859(final String source) {
    String result = "";
    final Base64.Encoder encoder = Base64.getEncoder();
    byte[] textByte = null;
    try {
      textByte = source.getBytes("ISO-8859-1");
      //注意此处的编码是ISO-8859-1
    } catch (final UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    result = encoder.encodeToString(textByte);
    return result;
  }
}
