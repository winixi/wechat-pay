package sh.evc.sdk.wechat.pay.request.mmpaymkttransfers;

import sh.evc.sdk.wechat.pay.dict.CheckName;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.mmpaymkttransfers.TransferSendResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 企业付款
 *
 * @author winixi
 * @date 2021/2/17 2:21 PM
 */
public class TransferSendRequest extends ApiRequest<TransferSendResponse> {

  /**
   * 商户账号appid
   * 申请商户号的appid或商户号绑定的appid
   */
  private String mchAppId;

  /**
   * 微信支付申请的商户号
   */
  private String mchId;

  /**
   * 设备号
   */
  private String deviceInfo;

  /**
   * 商户订单号，需保持唯一性
   * (只能是字母或者数字，不能包含有其它字符)
   */
  private String partnerTradeNo;

  /**
   * 用户openid
   */
  private String openId;

  /**
   * 校验用户姓名选项
   */
  private CheckName checkName;

  /**
   * 收款用户真实姓名。
   * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
   * 如需电子回单，需要传入收款用户姓名
   */
  private String reUserName;

  /**
   * 金额
   */
  private Integer amount;

  /**
   * 企业付款备注，必填。
   * 注意：备注中的敏感词会被转成字符*
   */
  private String desc;

  /**
   * 该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
   */
  private String spbillCreateIp;

  /**
   * 构造
   *
   * @param mchAppId
   * @param mchId
   * @param partnerTradeNo
   * @param openId
   * @param checkName
   * @param amount
   * @param desc
   */
  public TransferSendRequest(String mchAppId, String mchId, String partnerTradeNo, String openId, CheckName checkName, Integer amount, String desc) {
    this.mchAppId = mchAppId;
    this.mchId = mchId;
    this.partnerTradeNo = partnerTradeNo;
    this.openId = openId;
    this.checkName = checkName;
    this.amount = amount;
    this.desc = desc;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public void setReUserName(String reUserName) {
    this.reUserName = reUserName;
  }

  public void setSpbillCreateIp(String spbillCreateIp) {
    this.spbillCreateIp = spbillCreateIp;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("mch_appid", mchAppId);
    params.add("mchid", mchId);
    params.add("device_info", deviceInfo);
    params.add("partner_trade_no", partnerTradeNo);
    params.add("openid", openId);
    params.add("check_name", checkName.name());
    params.add("re_user_name", reUserName);
    params.add("amount", String.valueOf(amount));
    params.add("desc", desc);
    params.add("spbill_create_ip", spbillCreateIp);
    return params;
  }

  @Override
  public String getUri() {
    return "/mmpaymkttransfers/promotion/transfers";
  }

  @Override
  public Class<TransferSendResponse> getResponseClass() {
    return TransferSendResponse.class;
  }
}
