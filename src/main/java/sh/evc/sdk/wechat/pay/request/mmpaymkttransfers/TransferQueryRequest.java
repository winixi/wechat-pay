package sh.evc.sdk.wechat.pay.request.mmpaymkttransfers;

import sh.evc.sdk.wechat.pay.request.ApiRequest;
import sh.evc.sdk.wechat.pay.response.mmpaymkttransfers.TransferQueryResponse;
import sh.evc.sdk.wechat.pay.util.ParamsMap;

/**
 * 企业付款查询
 *
 * @author winixi
 * @date 2021/2/17 2:20 PM
 */
public class TransferQueryRequest extends ApiRequest<TransferQueryResponse> {

  /**
   * 商户号的appid
   */
  private String appId;

  /**
   * 微信支付分配的商户号
   */
  private String mchId;

  /**
   * 商户调用企业付款API时使用的商户订单号
   */
  private String partnerTradeNo;

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("appid", appId);
    params.add("mch_id", mchId);
    params.add("partner_trade_no", partnerTradeNo);
    return params;
  }

  @Override
  public String getUri() {
    return "/mmpaymkttransfers/gettransferinfo";
  }

  @Override
  public Class<TransferQueryResponse> getResponseClass() {
    return TransferQueryResponse.class;
  }
}
