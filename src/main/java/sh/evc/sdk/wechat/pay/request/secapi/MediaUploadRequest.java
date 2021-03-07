package sh.evc.sdk.wechat.pay.request.secapi;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.secapi.MediaUploadResponse;
import sh.evc.sdk.wechat.pay.util.DigestUtil;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

import java.io.File;

/**
 * 媒体文件上传
 * multipart/form-data
 *
 * @author winixi
 * @date 2021/2/8 4:04 PM
 */
public class MediaUploadRequest extends ApiRequest<MediaUploadResponse> {

  /**
   * 商户号
   */
  private String mchId;
  /**
   * 媒体文件名
   */
  private String media;
  /**
   * 文件
   */
  private File file;
  /**
   * hash
   */
  private String mediaHash;
  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  public MediaUploadRequest(String mchId, String media, File file) {
    this.mchId = mchId;
    this.media = media;
    this.file = file;
    this.mediaHash = DigestUtil.md5Hex(file).toLowerCase();
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  public String getMediaHash() {
    return mediaHash;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getMedia() {
    return media;
  }

  public void setMedia(String media) {
    this.media = media;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public void setMediaHash(String mediaHash) {
    this.mediaHash = mediaHash;
  }

  public SignType getSignType() {
    return signType;
  }

  @Override
  public File getFile() {
    return file;
  }

  @Override
  public ParamsMap getEntityParams() {
    return null;
  }

  @Override
  public ParamsMap getSignBasicParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("media_hash", mediaHash);
    params.add("sign_type", signType.getValue());
    return params;
  }

  @Override
  public ParamsMap getUnSignBasicParams() {
    ParamsMap params = new ParamsMap();
    params.add("media", media);
    return params;
  }

  @Override
  public String getUri() {
    return "/secapi/mch/uploadmedia";
  }

  @Override
  public Class<MediaUploadResponse> getResponseClass() {
    return MediaUploadResponse.class;
  }

  @Override
  public boolean useCert() {
    return true;
  }

  @Override
  public boolean useNonce() {
    return false;
  }
}
