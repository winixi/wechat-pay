# wechat-pay

简化业务代码中关于微信支付的逻辑，抽象微信支付sdk for 服务商

# 配置

> 测试代码配置文件  
src/test/resources/config.properties

> 服务商配置  
appId=  
apiKey=  
aesKey=  
mchId=

> 特约商户  
subAppId=  
subMchId=

> 通知  
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

# 实现接口列表

* 支付
    * 统一下单
    * 订单查询
    * 关闭订单
    * 退款
    * 退款查询

* 分账
    * 查询订单最大分账比例
    * 添加分账接收方
    * 删除分账接收方
    * 请求单次分账
    * 查询分账结果

* 进件  <未完成>
    * 小微申请入驻
    * 查询申请状态
    * 提交升级申请
    * 查询升级状态
    * 修改结算银行卡
    * 修改联系人
    * 关注配置
    * 支付目录配置
    * 绑定appId配置
    * 配置查询


# 联系 

winixi@qq.com
