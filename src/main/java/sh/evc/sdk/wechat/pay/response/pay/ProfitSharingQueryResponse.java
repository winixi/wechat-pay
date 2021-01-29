package sh.evc.sdk.wechat.pay.response.pay;

import com.fasterxml.jackson.core.type.TypeReference;
import sh.evc.sdk.wechat.pay.dict.CloseReason;
import sh.evc.sdk.wechat.pay.dict.ProfitSharingStatus;
import sh.evc.sdk.wechat.pay.domain.ReceiverQuery;
import sh.evc.sdk.wechat.pay.response.XmlResponse;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 分账查询
 *
 * @author winixi
 * @date 2021/1/28 4:05 PM
 */
public class ProfitSharingQueryResponse extends XmlResponse {

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 随机字符串
   */
  private String nonceStr;

  /**
   * 签名
   */
  private String sign;

  /**
   * 微信订单号
   */
  private String transactionId;

  /**
   * 商户分账单号
   */
  private String outOrderNo;

  /**
   * 微信分账单号
   */
  private String orderId;

  /**
   * 分账单状态
   */
  private ProfitSharingStatus status;

  /**
   * 关单原因
   */
  private CloseReason closeReason;

  /**
   * 分账接收方列表
   */
  private String receivers;

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

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

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutOrderNo() {
    return outOrderNo;
  }

  public void setOutOrderNo(String outOrderNo) {
    this.outOrderNo = outOrderNo;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public ProfitSharingStatus getStatus() {
    return status;
  }

  public void setStatus(ProfitSharingStatus status) {
    this.status = status;
  }

  public CloseReason getCloseReason() {
    return closeReason;
  }

  public void setCloseReason(CloseReason closeReason) {
    this.closeReason = closeReason;
  }

  public void setReceivers(String receivers) {
    this.receivers = receivers;
  }

  public List<ReceiverQuery> getReceivers() {
    return SerializeUtil.jsonToBean(receivers, new TypeReference<ArrayList<ReceiverQuery>>() {
    });
  }

  @Override
  public String toString() {
    return "ProfitSharingQueryResponse{" +
            "mchId='" + mchId + '\'' +
            ", subMchId='" + subMchId + '\'' +
            ", nonceStr='" + nonceStr + '\'' +
            ", sign='" + sign + '\'' +
            ", transactionId='" + transactionId + '\'' +
            ", outOrderNo='" + outOrderNo + '\'' +
            ", orderId='" + orderId + '\'' +
            ", status=" + status +
            ", closeReason=" + closeReason +
            ", receivers='" + receivers + '\'' +
            "} " + super.toString();
  }
}
