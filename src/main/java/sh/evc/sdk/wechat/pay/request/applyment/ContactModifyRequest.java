package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.ContactModifyResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 修改联系人
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=21_4
 *
 * @author winixi
 * @date 2021/1/29 4:44 PM
 */
public class ContactModifyRequest extends ApiRequest<ContactModifyResponse> {

  /**
   * 版本号
   */
  private String version = "1.0";

  /**
   * 服务商的商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 手机号
   */
  private String mobilePhone;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 商户简称
   */
  private String merchantName;

  /**
   * 加密的平台证书序列号
   */
  private String certSn;

  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填
   *
   * @param mchId
   * @param subMchId
   * @param certSn
   */
  public ContactModifyRequest(String mchId, String subMchId, String certSn) {
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.certSn = certSn;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setMobilePhone(String mobilePhone) {
    //todo 加密
    this.mobilePhone = mobilePhone;
  }

  public void setEmail(String email) {
    //todo 加密
    this.email = email;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public void setCertSn(String certSn) {
    this.certSn = certSn;
  }

  @Override
  public ParamsMap getRequestParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("mobile_phone", mobilePhone);
    params.add("email", email);
    params.add("merchant_name", merchantName);
    params.add("cert_sn", certSn);
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/modifycontactinfo";
  }

  @Override
  public Class<ContactModifyResponse> getResponseClass() {
    return ContactModifyResponse.class;
  }
}
