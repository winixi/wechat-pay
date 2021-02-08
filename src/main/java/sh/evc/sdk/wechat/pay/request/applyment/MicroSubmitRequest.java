package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.MicroSubmitResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.RsaEncryptUtil;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 小微商户入驻
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=19_2
 *
 * @author winixi
 * @date 2021/1/21 3:44 PM
 */
public class MicroSubmitRequest extends ApiRequest<MicroSubmitResponse> {

  /**
   * 版本号
   */
  private String version = "3.0";

  /**
   * 平台证书序列号
   */
  private String certSn;

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 业务申请编号，服务商自定义的商户唯一编号
   */
  private String businessCode;

  /**
   * 身份证人像面照片
   */
  private String idCardCopy;

  /**
   * 身份证国徽面照片
   */
  private String idCardNational;

  /**
   * 身份证姓名
   */
  private String idCardName;

  /**
   * 身份证号码
   */
  private String idCardNumber;

  /**
   * 身份证有效期
   */
  private String idCardValidTime;

  /**
   * 银行账户名
   */
  private String accountName;

  /**
   * 开户银行
   */
  private String accountBank;

  /**
   * 开户银行省市编码
   */
  private String bankAddressCode;

  /**
   * 开户银行全称（含支行）
   */
  private String bankName;

  /**
   * 银行帐号
   */
  private String accountNumber;

  /**
   * 门店名称
   */
  private String storeName;

  /**
   * 门店省市编码
   */
  private String storeAddressCode;

  /**
   * 门店街道名称
   */
  private String storeStreet;

  /**
   * 门店经度
   */
  private String storeLongitude;

  /**
   * 门店纬度
   */
  private String storeLatitude;

  /**
   * 门口照片
   */
  private String storeEntrancePic;

  /**
   * 店内环境照片
   */
  private String indoorPic;

  /**
   * 经营场地证明
   */
  private String addressCertification;

  /**
   * 商户简称
   */
  private String merchantShortname;

  /**
   * 客服电话
   */
  private String servicePhone;

  /**
   * 售卖商品/提供服务描述
   */
  private String productDesc;

  /**
   * 费率
   */
  private String rate;

  /**
   * 补充说明
   */
  private String businessAdditionDesc;

  /**
   * 补充材料，最多5张
   */
  private String[] businessAdditionPics;

  /**
   * 超级管理员姓名，敏感
   */
  private String contact;

  /**
   * 手机好吗，敏感
   */
  private String contactPhone;

  /**
   * 联系邮箱，敏感
   */
  private String contactEmail;

  /**
   * 签名方式
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 证书内容
   */
  private String cert;

  /**
   * 必填
   *
   * @param certSn
   * @param mchId
   * @param businessCode
   * @param idCardCopy
   * @param idCardNational
   * @param idCardName
   * @param idCardNumber
   * @param idCardValidTime
   * @param accountName
   * @param accountBank
   * @param bankAddressCode
   * @param accountNumber
   * @param storeName
   * @param storeAddressCode
   * @param storeStreet
   * @param storeEntrancePic
   * @param indoorPic
   * @param merchantShortname
   * @param servicePhone
   * @param productDesc
   * @param rate
   * @param contact
   * @param contactPhone
   * @param cert
   */
  public MicroSubmitRequest(String certSn, String mchId, String businessCode, String idCardCopy, String idCardNational, String idCardName, String idCardNumber, String idCardValidTime, String accountName, String accountBank, String bankAddressCode, String accountNumber, String storeName, String storeAddressCode, String storeStreet, String storeEntrancePic, String indoorPic, String merchantShortname, String servicePhone, String productDesc, String rate, String contact, String contactPhone, String cert) {
    this.certSn = certSn;
    this.mchId = mchId;
    this.businessCode = businessCode;
    this.idCardCopy = idCardCopy;
    this.idCardNational = idCardNational;
    this.idCardName = idCardName;
    this.idCardNumber = idCardNumber;
    this.idCardValidTime = idCardValidTime;
    this.accountName = accountName;
    this.accountBank = accountBank;
    this.bankAddressCode = bankAddressCode;
    this.accountNumber = accountNumber;
    this.storeName = storeName;
    this.storeAddressCode = storeAddressCode;
    this.storeStreet = storeStreet;
    this.storeEntrancePic = storeEntrancePic;
    this.indoorPic = indoorPic;
    this.merchantShortname = merchantShortname;
    this.servicePhone = servicePhone;
    this.productDesc = productDesc;
    this.rate = rate;
    this.contact = contact;
    this.contactPhone = contactPhone;
    this.cert = cert;
  }

  public void setCertSn(String certSn) {
    this.certSn = certSn;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode;
  }

  public void setIdCardCopy(String idCardCopy) {
    this.idCardCopy = idCardCopy;
  }

  public void setIdCardNational(String idCardNational) {
    this.idCardNational = idCardNational;
  }

  public void setIdCardName(String idCardName) {
    this.idCardName = idCardName;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public void setIdCardValidTime(String idCardValidTime) {
    this.idCardValidTime = idCardValidTime;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public void setAccountBank(String accountBank) {
    this.accountBank = accountBank;
  }

  public void setBankAddressCode(String bankAddressCode) {
    this.bankAddressCode = bankAddressCode;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public void setStoreAddressCode(String storeAddressCode) {
    this.storeAddressCode = storeAddressCode;
  }

  public void setStoreStreet(String storeStreet) {
    this.storeStreet = storeStreet;
  }

  public void setStoreLongitude(String storeLongitude) {
    this.storeLongitude = storeLongitude;
  }

  public void setStoreLatitude(String storeLatitude) {
    this.storeLatitude = storeLatitude;
  }

  public void setStoreEntrancePic(String storeEntrancePic) {
    this.storeEntrancePic = storeEntrancePic;
  }

  public void setIndoorPic(String indoorPic) {
    this.indoorPic = indoorPic;
  }

  public void setAddressCertification(String addressCertification) {
    this.addressCertification = addressCertification;
  }

  public void setMerchantShortname(String merchantShortname) {
    this.merchantShortname = merchantShortname;
  }

  public void setServicePhone(String servicePhone) {
    this.servicePhone = servicePhone;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public void setBusinessAdditionDesc(String businessAdditionDesc) {
    this.businessAdditionDesc = businessAdditionDesc;
  }

  public void setBusinessAdditionPics(String[] businessAdditionPics) {
    this.businessAdditionPics = businessAdditionPics;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public void setCert(String cert) {
    this.cert = cert;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("version", version);
    params.add("mch_id", mchId);
    params.add("cert_sn", certSn);
    params.add("business_code", businessCode);
    params.add("id_card_copy", idCardCopy);
    params.add("id_card_national", idCardNational);
    params.add("id_card_name", RsaEncryptUtil.rsaEncrypt(idCardName, cert));
    params.add("id_card_number", RsaEncryptUtil.rsaEncrypt(idCardNumber, cert));
    params.add("id_card_valid_time", idCardValidTime);
    params.add("account_name", RsaEncryptUtil.rsaEncrypt(accountName, cert));
    params.add("account_bank", accountBank);
    params.add("bank_address_code", bankAddressCode);
    params.add("bank_name", bankName);
    params.add("account_number", RsaEncryptUtil.rsaEncrypt(accountNumber, cert));
    params.add("store_name", storeName);
    params.add("store_address_code", storeAddressCode);
    params.add("store_street", storeStreet);
    params.add("store_longitude", storeLongitude);
    params.add("store_latitude", storeLatitude);
    params.add("store_entrance_pic", storeEntrancePic);
    params.add("indoor_pic", indoorPic);
    params.add("address_certification", addressCertification);
    params.add("merchant_shortname", merchantShortname);
    params.add("service_phone", servicePhone);
    params.add("product_desc", productDesc);
    params.add("rate", rate);
    params.add("business_addition_desc", businessAdditionDesc);
    params.add("business_addition_pics", SerializeUtil.beanToJson(businessAdditionPics));
    params.add("contact", RsaEncryptUtil.rsaEncrypt(contact, cert));
    params.add("contact_phone", RsaEncryptUtil.rsaEncrypt(contactPhone, cert));
    params.add("contact_email", RsaEncryptUtil.rsaEncrypt(contactEmail, cert));
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/submit";
  }

  @Override
  public Class<MicroSubmitResponse> getResponseClass() {
    return MicroSubmitResponse.class;
  }

  @Override
  public boolean useCert() {
    return true;
  }
}

