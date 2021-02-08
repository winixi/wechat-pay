package sh.evc.sdk.wechat.pay.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 定制hash
 *
 * @author winixi
 * @date 2021/2/8 4:13 PM
 */
public class DigestUtil {

  private final static Logger log = LoggerFactory.getLogger(DigestUtil.class);

  /**
   * file hash
   *
   * @param file
   * @return
   */
  public static String md5Hex(File file) {
    try {
      return DigestUtils.md5Hex(new FileInputStream(file));
    } catch (IOException e) {
      log.error("计算文件hash错误{}", ErrorUtil.getStackTraceAsString(e));
    }
    return null;
  }
}
