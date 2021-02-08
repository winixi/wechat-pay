package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.FeeType;
import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.domain.SceneInfo;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;
import sh.evc.sdk.wechat.pay.util.DateUtil;
import sh.evc.sdk.wechat.pay.util.ParamsMap;
import sh.evc.sdk.wechat.pay.util.SerializeUtil;

/**
 * 统一下单
 * https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_1
 *
 * @author winixi
 * @date 2021/1/22 9:37 AM
 */
public class UnifiedOrderRequest extends ApiRequest<UnifiedOrderResponse> {

  /**
   * 应用ID
   */
  private String appId;

  /**
   * 商户号
   */
  private String mchId;

  /**
   * 子商户应用ID
   */
  private String subAppId;

  /**
   * 子商户号
   */
  private String subMchId;

  /**
   * 设备号
   * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
   */
  private String deviceInfo;

  /**
   * 签名方式
   */
  private SignType signType = SignType.HMACSHA256;

  /**
   * 商品描述
   */
  private String body;

  /**
   * 商品详情
   */
  private String detail;

  /**
   * 附加数据
   */
  private String attach;

  /**
   * 商户订单号
   */
  private String outTradeNo;

  /**
   * 货币类型
   */
  private FeeType feeType = FeeType.CNY;

  /**
   * 总金额
   */
  private Integer totalFee;

  /**
   * 终端IP
   */
  private String spbillCreateIp;

  /**
   * 交易开始时间
   */
  private String timeStart = DateUtil.getPayTimeStart();

  /**
   * 交易结束时间
   */
  private String timeExpire = DateUtil.getPayTimeExpire(30);

  /**
   * 订单优惠标记
   */
  private String goodsTag;

  /**
   * 通知地址
   */
  private String notifyUrl;

  /**
   * 交易类型
   */
  private TradeType tradeType;

  /**
   * 指定支付方式
   */
  private String limitPay;

  /**
   * 用户标识
   */
  private String openId;

  /**
   * 用户子标识
   */
  private String subOpenId;

  /**
   * 电子发票入口开放标识
   */
  private String receipt;

  /**
   * 是否需要分账
   * Y-是，需要分账
   * N-否，不分账
   * 字母要求大写，不传默认不分账
   */
  private String profitSharing;

  /**
   * 场景信息
   */
  private SceneInfo sceneInfo;

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public void setSignType(SignType signType) {
    this.signType = signType;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public void setSpbillCreateIp(String spbillCreateIp) {
    this.spbillCreateIp = spbillCreateIp;
  }

  public void setTimeStart(String timeStart) {
    this.timeStart = timeStart;
  }

  public void setTimeExpire(String timeExpire) {
    this.timeExpire = timeExpire;
  }

  public void setGoodsTag(String goodsTag) {
    this.goodsTag = goodsTag;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public void setLimitPay(String limitPay) {
    this.limitPay = limitPay;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public void setSubOpenId(String subOpenId) {
    this.subOpenId = subOpenId;
  }

  public void setReceipt(String receipt) {
    this.receipt = receipt;
  }

  public void setProfitSharing(String profitSharing) {
    this.profitSharing = profitSharing;
  }

  public void setSceneInfo(SceneInfo sceneInfo) {
    this.sceneInfo = sceneInfo;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("mch_id", mchId);
    params.add("sub_appid", subAppId);
    params.add("sub_mch_id", subMchId);
    params.add("device_info", deviceInfo);
    params.add("sign_type", signType.getName());
    params.add("body", body);
    params.add("detail", detail);
    params.add("attach", attach);
    params.add("out_trade_no", outTradeNo);
    params.add("fee_type", feeType.name());
    params.add("total_fee", String.valueOf(totalFee));
    params.add("spbill_create_ip", spbillCreateIp);
    params.add("time_start", timeStart);
    params.add("time_expire", timeExpire);
    params.add("goods_tag", goodsTag);
    params.add("notify_url", notifyUrl);
    params.add("trade_type", tradeType.name());
    params.add("limit_pay", limitPay);
    params.add("openid", openId);
    params.add("sub_openid", subOpenId);
    params.add("receipt", receipt);
    params.add("profit_sharing", profitSharing);
    if (sceneInfo != null) {
      params.add("scene_info", "{\"store_info\":" + SerializeUtil.beanToJson(sceneInfo) + "}");
    }
    return params;
  }

  @Override
  public String getUri() {
    return "/pay/unifiedorder";
  }

  @Override
  public Class<UnifiedOrderResponse> getResponseClass() {
    return UnifiedOrderResponse.class;
  }

  /**
   * 必填参数
   *
   * @param appId
   * @param mchId
   * @param subMchId
   * @param body
   * @param outTradeNo
   * @param totalFee
   * @param spbillCreateIp
   * @param notifyUrl
   * @param tradeType
   */
  public UnifiedOrderRequest(String appId, String mchId, String subMchId, String body, String outTradeNo, Integer totalFee, String spbillCreateIp, String notifyUrl, TradeType tradeType) {
    this.appId = appId;
    this.mchId = mchId;
    this.subMchId = subMchId;
    this.body = body;
    this.outTradeNo = outTradeNo;
    this.totalFee = totalFee;
    this.spbillCreateIp = spbillCreateIp;
    this.notifyUrl = notifyUrl;
    this.tradeType = tradeType;
  }
}
