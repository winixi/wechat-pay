package sh.evc.sdk.wechat.pay.request.pay;

import sh.evc.sdk.wechat.pay.dict.SignType;
import sh.evc.sdk.wechat.pay.dict.TradeType;
import sh.evc.sdk.wechat.pay.domain.SceneInfo;
import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.pay.UnifiedOrderResponse;

import java.util.Map;

/**
 * 生成预支付订单
 *
 * @author winixi
 * @date 2021/1/22 9:37 AM
 */
public class UnifiedOrderRequest extends ApiRequest<UnifiedOrderResponse> {

  /**
   * 应用id
   */
  private String appId;

  /**
   *
   */
  private String mchId;

  /**
   *
   */
  private String subAppId;

  /**
   *
   */
  private String subMchId;

  /**
   *
   */
  private String deviceInfo;

  /**
   *
   */
  private String nonceStr;

  /**
   *
   */
  private SignType signType;

  /**
   *
   */
  private String body;

  /**
   *
   */
  private String detail;

  /**
   *
   */
  private String attach;

  /**
   *
   */
  private String outTradeNo;

  /**
   *
   */
  private String feeType;

  /**
   *
   */
  private Integer totalFee;

  /**
   *
   */
  private String spbillCreateIp;

  /**
   *
   */
  private String timeStart;

  /**
   *
   */
  private String timeExpire;

  /**
   *
   */
  private String goodsTag;

  /**
   *
   */
  private String notifyUrl;

  /**
   *
   */
  private TradeType tradeType;

  /**
   *
   */
  private String limitPay;

  /**
   *
   */
  private String openId;

  /**
   *
   */
  private String subOpenId;

  /**
   *
   */
  private String receipt;

  /**
   *
   */
  private String profitSharing;

  /**
   *
   */
  private SceneInfo sceneInfo;

  @Override
  public Map<String, String> getRequestParams() {
    return null;
  }

  @Override
  public String getUri() {
    return "/pay/unifiedorder";
  }

  @Override
  public Class<UnifiedOrderResponse> getResponseClass() {
    return UnifiedOrderResponse.class;
  }
}
