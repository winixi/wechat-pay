package sh.evc.sdk.wechat.pay.util;

import sh.evc.sdk.wechat.pay.dict.SignType;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付
 *
 * @author winixi
 * @date 2021/2/28 4:22 PM
 */
public class WeappUtil {

  /**
   * 整理微信小程序请求参数
   *
   * @param appId
   * @param apiKey
   * @param prepayId
   * @param signType
   * @return
   * @throws Exception
   */
  public static Map<String, String> getParams(String appId, String apiKey, String prepayId, String signType) throws Exception {
    Map<String, String> out = new HashMap<>();
    out.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
    out.put("nonceStr", NonceStrUtil.generate());
    out.put("package", "prepay_id=" + prepayId);
    out.put("signType", signType);
    out.put("paySign", getPaySign(appId, apiKey, out));
    return out;
  }

  /**
   * 微信支付二次签名
   *
   * @param appId
   * @param apiKey
   * @param params
   * @return
   * @throws Exception
   */
  private static String getPaySign(String appId, String apiKey, Map<String, String> params) throws Exception {
    StringBuilder sb = new StringBuilder();

    sb.append("appId=" + appId).append("&")
            .append("nonceStr=" + params.get("nonceStr")).append("&")
            .append("package=" + params.get("package")).append("&")
            .append("signType=" + params.get("signType")).append("&")
            .append("timeStamp=" + params.get("timeStamp")).append("&")
            .append("key=" + apiKey);

    SignType signType = SignType.getByValue(params.get("signType"));

    if (signType == SignType.HMACSHA256) {
      return SignatureUtil.HMACSHA256(sb.toString(), apiKey);
    } else if (signType == SignType.MD5) {
      return SignatureUtil.MD5(sb.toString());
    }
    throw new Exception("签名类型无效" + params.get("signType"));
  }
}
