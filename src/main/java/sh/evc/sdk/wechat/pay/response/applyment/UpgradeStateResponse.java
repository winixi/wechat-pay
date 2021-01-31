package sh.evc.sdk.wechat.pay.response.applyment;

import com.fasterxml.jackson.core.type.TypeReference;
import sh.evc.sdk.wechat.pay.dict.ApplymentState;
import sh.evc.sdk.wechat.pay.domain.AuditDetail;
import sh.evc.sdk.wechat.pay.response.XmlResponse;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

import java.util.List;

/**
 * 升级状态查询
 *
 * @author winixi
 * @date 2021/1/29 4:53 PM
 */
public class UpgradeStateResponse extends XmlResponse {

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  /**
   * 商户申请号
   */
  private String applymentId;

  /**
   * 申请状态
   */
  private ApplymentState applymentState;

  /**
   * 申请状态描述
   */
  private String applymentStateDesc;

  /**
   * 小微商户号
   */
  private String subMchId;

  /**
   * 签名url
   */
  private String signUrl;

  /**
   * 审核详情
   */
  private String auditDetail;

  /* 以下字段当 applyment_state 为ACCOUNT_NEED_VERIFY 时有返回，请商户按照以下信息进行汇款，以完成账户验证 */
  /**
   * 付款户名
   */
  private String accountName;

  /**
   * 汇款金额
   */
  private String payAmount;

  /**
   * 收款卡号
   */
  private String destinationAccountNumber;

  /**
   * 收款户名
   */
  private String destinationAccountName;

  /**
   * 开户银行
   */
  private String destinationAccountBank;

  /**
   * 首款账户的省市
   */
  private String city;

  /**
   * 汇款备注
   */
  private String remark;

  /**
   * 汇款截止时间
   */
  private String deadlineTime;


  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getApplymentId() {
    return applymentId;
  }

  public void setApplymentId(String applymentId) {
    this.applymentId = applymentId;
  }

  public ApplymentState getApplymentState() {
    return applymentState;
  }

  public void setApplymentState(ApplymentState applymentState) {
    this.applymentState = applymentState;
  }

  public String getApplymentStateDesc() {
    return applymentStateDesc;
  }

  public void setApplymentStateDesc(String applymentStateDesc) {
    this.applymentStateDesc = applymentStateDesc;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public String getSignUrl() {
    return signUrl;
  }

  public void setSignUrl(String signUrl) {
    this.signUrl = signUrl;
  }

  public List<AuditDetail> getAuditDetail() {
    return SerializeUtil.jsonToBean(auditDetail, new TypeReference<List<AuditDetail>>() {
    });
  }

  public void setAuditDetail(String auditDetail) {
    this.auditDetail = auditDetail;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(String payAmount) {
    this.payAmount = payAmount;
  }

  public String getDestinationAccountNumber() {
    return destinationAccountNumber;
  }

  public void setDestinationAccountNumber(String destinationAccountNumber) {
    this.destinationAccountNumber = destinationAccountNumber;
  }

  public String getDestinationAccountName() {
    return destinationAccountName;
  }

  public void setDestinationAccountName(String destinationAccountName) {
    this.destinationAccountName = destinationAccountName;
  }

  public String getDestinationAccountBank() {
    return destinationAccountBank;
  }

  public void setDestinationAccountBank(String destinationAccountBank) {
    this.destinationAccountBank = destinationAccountBank;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getDeadlineTime() {
    return deadlineTime;
  }

  public void setDeadlineTime(String deadlineTime) {
    this.deadlineTime = deadlineTime;
  }

  @Override
  public String toString() {
    return "UpgradeStateResponse{" +
            "nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", applymentId='" + applymentId + '\'' +
            ", applymentState=" + applymentState +
            ", applymentStateDesc='" + applymentStateDesc + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", signUrl='" + signUrl + '\'' +
            ", auditDetail='" + auditDetail + '\'' +
            ", accountName='" + accountName + '\'' +
            ", payAmount='" + payAmount + '\'' +
            ", destinationAccountNumber='" + destinationAccountNumber + '\'' +
            ", destinationAccountName='" + destinationAccountName + '\'' +
            ", destinationAccountBank='" + destinationAccountBank + '\'' +
            ", city='" + city + '\'' +
            ", remark='" + remark + '\'' +
            ", deadlineTime='" + deadlineTime + '\'' +
            "} " + super.toString();
  }
}
