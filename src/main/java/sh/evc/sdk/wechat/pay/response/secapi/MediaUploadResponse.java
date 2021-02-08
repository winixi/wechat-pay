package sh.evc.sdk.wechat.pay.response.secapi;

import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 媒体上传
 *
 * @author winixi
 * @date 2021/2/8 4:04 PM
 */
public class MediaUploadResponse extends XmlResponse {

  /**
   * 媒体标识id
   */
  private String mediaId;

  /**
   * 签名
   */
  private String sign;

  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  @Override
  public String toString() {
    return "MediaUploadResponse{" +
            "mediaId='" + mediaId + '\'' +
            ", sign='" + sign + '\'' +
            "} " + super.toString();
  }
}
