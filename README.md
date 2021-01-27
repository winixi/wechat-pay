# wechat-pay
微信支付SDK  
XML服务商版本
---
# 说明
简化业务代码中关于微信支付的逻辑，抽象微信支付sdk for 服务商

# 配置  

>测试代码配置文件  
src/test/resources/config.properties

>服务商配置  
appId=  
apiKey=  
aesKey=  
mchId=  

>特约商户  
subAppId=  
subMchId=  

>通知  
payNotify=http://balabalala.cn:9090/wechat-pay/payNotify  
refundNotify=http://balabalala.cn:9090/wechat-pay/refundNotify  
profitNotify=http://balabalala.cn:9090/wechat-pay/profitNotify  


# 代码示例
```
/**
 * 统一下单
 */
public void unifiedOrder() {
    String appId = config.getAppId();
    String mchId = config.getMchId();
    String subMchId = config.getSubMchId();
    String body = "测试支付";
    String outTradeNo = NonceStrUtil.generate();
    int totalFee = 100;
    String spbillCreateIp = "127.0.0.1";
    String notifyUrl = config.getPayNotify();
    UnifiedOrderRequest request = new UnifiedOrderRequest(appId, mchId, subMchId, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, TradeType.JSAPI);
    request.setSubAppId(config.getSubAppId());
    request.setSubOpenId("oGimf4l6H20K00gDjXzr-cJFozP4");
    request.setProfitSharing("Y");

    UnifiedOrderResponse response = client.execute(request);
    JsonFormat.print(response);
  }
```

# 联系人  

winixi@qq.com
