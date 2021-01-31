package sh.evc.sdk.wechat.pay.response.applyment;

import com.fasterxml.jackson.core.type.TypeReference;
import sh.evc.sdk.wechat.pay.dict.ApplymentState;
import sh.evc.sdk.wechat.pay.domain.AuditDetail;
import sh.evc.sdk.wechat.pay.response.XmlResponse;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

import java.util.List;

/**
 * 申请状态查询
 *
 * @author winixi
 * @date 2021/1/29 5:01 PM
 */
public class SubmitStateResponse extends XmlResponse {

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

  @Override
  public String toString() {
    return "SubmitStateResponse{" +
            "nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", applymentId='" + applymentId + '\'' +
            ", applymentState='" + applymentState + '\'' +
            ", applymentStateDesc='" + applymentStateDesc + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", signUrl='" + signUrl + '\'' +
            ", auditDetail='" + auditDetail + '\'' +
            "} " + super.toString();
  }
}
