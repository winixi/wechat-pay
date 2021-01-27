package sh.evc.sdk.wechat.pay.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import sh.evc.sdk.wechat.pay.dict.RefundAccount;
import sh.evc.sdk.wechat.pay.dict.RefundRequestSource;
import sh.evc.sdk.wechat.pay.dict.RefundStatus;

/**
 * 通知解密的退款信息
 *
 * @author winixi
 * @date 2021/1/27 3:51 PM
 */
@JacksonXmlRootElement(localName = "root")
public class RefundInfo {

  /**
   * 微信支付订单号
   */
  private String transactionId;

  /**
   * 商户订单号
   */
  private String outTradeNo;

  /**
   * 商户退款单号
   */
  private String outRefundNo;

  /**
   * 订单总金额
   */
  private Integer totalFee;

  /**
   * 应结订单金额
   */
  private Integer settlementTotalFee;

  /**
   * 微信退款单号
   */
  private String refundId;

  /**
   * 申请退款金额
   */
  private Integer refundFee;

  /**
   * 退款金额
   */
  private Integer settlementRefundFee;

  /**
   * 退款状态
   */
  private RefundStatus refundStatus;

  /**
   * 退款成功时间，2016-07-25 15:26:26
   */
  private String successTime;

  /**
   * 退款资金来源
   */
  private RefundAccount refundAccount;

  /**
   * 退款入账账户，这个accout 没有n
   */
  private String refundRecvAccout;

  /**
   * 退款发起来源
   */
  private RefundRequestSource refundRequestSource;

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getOutRefundNo() {
    return outRefundNo;
  }

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }

  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public Integer getSettlementTotalFee() {
    return settlementTotalFee;
  }

  public void setSettlementTotalFee(Integer settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
  }

  public String getRefundId() {
    return refundId;
  }

  public void setRefundId(String refundId) {
    this.refundId = refundId;
  }

  public Integer getRefundFee() {
    return refundFee;
  }

  public void setRefundFee(Integer refundFee) {
    this.refundFee = refundFee;
  }

  public Integer getSettlementRefundFee() {
    return settlementRefundFee;
  }

  public void setSettlementRefundFee(Integer settlementRefundFee) {
    this.settlementRefundFee = settlementRefundFee;
  }

  public RefundStatus getRefundStatus() {
    return refundStatus;
  }

  public void setRefundStatus(RefundStatus refundStatus) {
    this.refundStatus = refundStatus;
  }

  public String getSuccessTime() {
    return successTime;
  }

  public void setSuccessTime(String successTime) {
    this.successTime = successTime;
  }

  public RefundAccount getRefundAccount() {
    return refundAccount;
  }

  public void setRefundAccount(RefundAccount refundAccount) {
    this.refundAccount = refundAccount;
  }

  public String getRefundRecvAccout() {
    return refundRecvAccout;
  }

  public void setRefundRecvAccout(String refundRecvAccout) {
    this.refundRecvAccout = refundRecvAccout;
  }

  public RefundRequestSource getRefundRequestSource() {
    return refundRequestSource;
  }

  public void setRefundRequestSource(RefundRequestSource refundRequestSource) {
    this.refundRequestSource = refundRequestSource;
  }

  @Override
  public String toString() {
    return "RefundInfo{" +
            "transactionId='" + transactionId + '\'' +
            ", outTradeNo='" + outTradeNo + '\'' +
            ", outRefundNo='" + outRefundNo + '\'' +
            ", totalFee=" + totalFee +
            ", settlementTotalFee=" + settlementTotalFee +
            ", refundId='" + refundId + '\'' +
            ", refundFee=" + refundFee +
            ", settlementRefundFee=" + settlementRefundFee +
            ", refundStatus=" + refundStatus +
            ", successTime='" + successTime + '\'' +
            ", refundAccount=" + refundAccount +
            ", refundRecvAccout='" + refundRecvAccout + '\'' +
            ", refundRequestSource=" + refundRequestSource +
            '}';
  }
}
