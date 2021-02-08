package sh.evc.sdk.wechat.pay.request.applyment;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.applyment.ArchivesModifyResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 修改结算银行卡
 * https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=21_2
 *
 * @author winixi
 * @date 2021/1/29 4:46 PM
 */
public class ArchivesModifyRequest extends ApiRequest<ArchivesModifyResponse> {

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
   * 银行卡号
   */
  private String accountNumber;

  /**
   * 开户银行全称（含支行）
   * 1）17家直连银行无需填写，其他银行请务必填写
   * 2）需填写银行全称，如"深圳农村商业银行XXX支行"
   */
  private String bankName;

  /**
   * 开户银行
   */
  private String accountBank;

  /**
   * 开户银行省市代码
   */
  private String bankAddressCode;

  /**
   * 加密的平台证书序列号
   */
  private String certSn;

  /**
   * 签名类型
   */
  private SignType signType = SignType.HMACSHA256;

  public ArchivesModifyRequest(String mchId, String subMchId, String bankAddressCode, String certSn) {
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.bankAddressCode = bankAddressCode;
    this.certSn = certSn;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setAccountNumber(String accountNumber) {
    //todo 加密
    this.accountNumber = accountNumber;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public void setAccountBank(String accountBank) {
    this.accountBank = accountBank;
  }

  public void setBankAddressCode(String bankAddressCode) {
    this.bankAddressCode = bankAddressCode;
  }

  public void setCertSn(String certSn) {
    this.certSn = certSn;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("version", version);
    params.add("mchId", mchId);
    params.add("sub_mch_id", subMchId);
    params.add("account_number", accountNumber);
    params.add("bank_name", bankName);
    params.add("account_bank", accountBank);
    params.add("bank_address_code", bankAddressCode);
    params.add("cert_sn", certSn);
    params.add("sign_type", signType.getName());
    return params;
  }

  @Override
  public String getUri() {
    return "/applyment/micro/modifyarchives";
  }

  @Override
  public Class<ArchivesModifyResponse> getResponseClass() {
    return ArchivesModifyResponse.class;
  }
}
