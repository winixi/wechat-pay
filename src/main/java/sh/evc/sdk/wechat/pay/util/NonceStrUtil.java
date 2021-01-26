package sh.evc.sdk.wechat.pay.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 随机字符串
 *
 * @author winixi
 * @date 2021/1/26 10:33 AM
 */
public class NonceStrUtil {

  private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final Random RANDOM = new SecureRandom();

  /**
   * 获取随机字符串 Nonce Str
   *
   * @return String 随机字符串
   */
  public static String generate() {
    char[] nonceChars = new char[32];
    for (int index = 0; index < nonceChars.length; ++index) {
      nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
    }
    return new String(nonceChars);
  }
}
