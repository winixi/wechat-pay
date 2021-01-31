package sh.evc.sdk.wechat.pay.domain;

/**
 * 审核详情
 *
 * @author winixi
 * @date 2021/1/31 3:02 PM
 */
public class AuditDetail {

  /**
   * 参数名称
   */
  private String paramName;

  /**
   * 驳回原因描述
   */
  private String rejectReason;

  public String getParamName() {
    return paramName;
  }

  public void setParamName(String paramName) {
    this.paramName = paramName;
  }

  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }

  @Override
  public String toString() {
    return "AuditDetail{" +
            "paramName='" + paramName + '\'' +
            ", rejectReason='" + rejectReason + '\'' +
            '}';
  }
}
