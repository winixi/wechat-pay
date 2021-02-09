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
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  public MediaUploadRequest(String mchId, String media, File file) {
    this.mchId = mchId;
    this.media = media;
    this.file = file;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
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
    params.add("media_hash", DigestUtil.md5Hex(file).toLowerCase());
    params.add("sign_type", signType.getName());
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
