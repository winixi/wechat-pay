package sh.evc.sdk.wechat.pay.domain;

import java.util.Arrays;

/**
 * 证书
 *
 * @author winixi
 * @date 2021/2/8 3:39 PM
 */
public class Certificate {

  /**
   * 数据体
   */
  private CertificateData[] data;

  public CertificateData[] getData() {
    return data;
  }

  public void setData(CertificateData[] data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Certificate{" +
            "data=" + Arrays.toString(data) +
            '}';
  }
}
