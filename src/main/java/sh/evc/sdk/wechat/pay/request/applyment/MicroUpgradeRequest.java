package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.BusinessLicenceType;
import sh.evc.sdk.wechat.pay.dict.BusinessScene;
import sh.evc.sdk.wechat.pay.dict.OrganizationType;
import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.MicroUpgradeResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 小微升级
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=28_2&index=2
 *
 * @author winixi
 * @date 2021/1/29 4:49 PM
 */
public class MicroUpgradeRequest extends ApiRequest<MicroUpgradeResponse> {

  /**
   * 接口版本号
   */
  private String version = "1.0";

  /**
   * 证书序列号
   */
  private String certSn;

  /**
   * 服务商商户号
   */
  private String mchId;

  /**
   * 小微商户号
   */
  private String subMchId;

  /**
   * 主体类型
   */
  private OrganizationType organizationType;

  /**
   * 营业执照扫描件
   */
  private String businessLicenseCopy;

  /**
   * 营业执照注册号
   */
  private String businessLicenseNumber;

  /**
   * 商户名称
   */
  private String merchantName;

  /**
   * 注册地址
   */
  private String companyAddress;

  /**
   * 法人代表
   */
  private String legalPerson;

  /**
   * 营业期限
   */
  private String[] businessTime;

  /**
   * 营业执照类型
   */
  private BusinessLicenceType businessLicenceType;

  /**
   * 组织机构代码证照片
   */
  private String organizationCopy;

  /**
   * 组织机构代码
   */
  private String organizationNumber;

  /**
   * 组织机构代码有效期限
   */
  private String[] organizationTime;

  /**
   * 开户名称
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
   * 开户银行全称，含支行
   */
  private String bankName;

  /**
   * 银行卡号
   */
  private String accountNumber;

  /**
   * 商户简称
   */
  private String merchantShortname;

  /**
   * 费率结算规则
   */
  private String business;

  /**
   * 特殊资质
   */
  private String[] qualifications;

  /**
   * 经营场景
   */
  private BusinessScene[] businessScene;

  /**
   * 补充说明
   */
  private String businessAdditionDesc;

  /**
   * 补充材料
   */
  private String[] businessAdditionPics;

  /**
   * 联系邮箱，敏感
   * 需要带@，遵循邮箱格式校验 ，若小微商户入驻时没有提交邮箱，该字段必填
   */
  private String contactEmail;

  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 必填
   *
   * @param certSn
   * @param mchId
   * @param subMchId
   * @param organizationType
   * @param businessLicenseCopy
   * @param businessLicenseNumber
   * @param merchantName
   * @param companyAddress
   * @param legalPerson
   * @param businessTime
   * @param businessLicenceType
   * @param merchantShortname
   * @param business
   * @param businessScene
   */
  public MicroUpgradeRequest(String certSn, String mchId, String subMchId, OrganizationType organizationType, String businessLicenseCopy, String businessLicenseNumber, String merchantName, String companyAddress, String legalPerson, String[] businessTime, BusinessLicenceType businessLicenceType, String merchantShortname, String business, BusinessScene[] businessScene) {
    this.certSn = certSn;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.organizationType = organizationType;
    this.businessLicenseCopy = businessLicenseCopy;
    this.businessLicenseNumber = businessLicenseNumber;
    this.merchantName = merchantName;
    this.companyAddress = companyAddress;
    this.legalPerson = legalPerson;
    this.businessTime = businessTime;
    this.businessLicenceType = businessLicenceType;
    this.merchantShortname = merchantShortname;
    this.business = business;
    this.businessScene = businessScene;
  }

  public void setCertSn(String certSn) {
    this.certSn = certSn;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setOrganizationType(OrganizationType organizationType) {
    this.organizationType = organizationType;
  }

  public void setBusinessLicenseCopy(String businessLicenseCopy) {
    this.businessLicenseCopy = businessLicenseCopy;
  }

  public void setBusinessLicenseNumber(String businessLicenseNumber) {
    this.businessLicenseNumber = businessLicenseNumber;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public void setBusinessTime(String[] businessTime) {
    this.businessTime = businessTime;
  }

  public void setBusinessLicenceType(BusinessLicenceType businessLicenceType) {
    this.businessLicenceType = businessLicenceType;
  }

  public void setOrganizationCopy(String organizationCopy) {
    this.organizationCopy = organizationCopy;
  }

  public void setOrganizationNumber(String organizationNumber) {
    this.organizationNumber = organizationNumber;
  }

  public void setOrganizationTime(String[] organizationTime) {
    this.organizationTime = organizationTime;
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

  public void setMerchantShortname(String merchantShortname) {
    this.merchantShortname = merchantShortname;
  }

  public void setBusiness(String business) {
    this.business = business;
  }

  public void setQualifications(String[] qualifications) {
    this.qualifications = qualifications;
  }

  public void setBusinessScene(BusinessScene[] businessScene) {
    this.businessScene = businessScene;
  }

  public void setBusinessAdditionDesc(String businessAdditionDesc) {
    this.businessAdditionDesc = businessAdditionDesc;
  }

  public void setBusinessAdditionPics(String[] businessAdditionPics) {
    this.businessAdditionPics = businessAdditionPics;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("version", version);
    params.add("cert_sn", certSn);
    params.add("mch_id", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("organization_type", organizationType.getValue());
    params.add("business_license_copy", businessLicenseCopy);
    params.add("business_license_number", businessLicenseNumber);
    params.add("merchant_name", merchantName);
    params.add("company_address", companyAddress);
    params.add("legal_person", legalPerson);
    params.add("business_time", SerializeUtil.beanToJson(businessTime));
    params.add("business_license_type", businessLicenceType.getValue());
    params.add("merchant_shortname", merchantShortname);
    params.add("business", business);
    params.add("business_scene", SerializeUtil.beanToJson(businessScene));
    params.add("organization_copy", organizationCopy);
    params.add("organization_number", organizationNumber);
    params.add("organization_time", SerializeUtil.beanToJson(organizationTime));
    params.add("account_name", accountName);
    params.add("account_bank", accountBank);
    params.add("bank_address_code", bankAddressCode);
    params.add("bank_name", bankName);
    params.add("account_number", accountNumber);
    params.add("qualifications", SerializeUtil.beanToJson(qualifications));
    params.add("business_addition_desc", businessAdditionDesc);
    params.add("business_addition_pics", SerializeUtil.beanToJson(businessAdditionPics));
    params.add("contact_email", contactEmail);
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/submitupgrade";
  }

  @Override
  public Class<MicroUpgradeResponse> getResponseClass() {
    return MicroUpgradeResponse.class;
  }
}
