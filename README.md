# wechat-pay

简化服务端代码中关于微信支付的逻辑，简化服务端对支付接口的访问

# 配置文件

> 作为服务商配置文件
src/test/resources/service.properties

```
# 服务商配置  
appId=  
apiKey=  
aesKey=  
mchId=

# 特约商户  
subAppId=  
subMchId=

# 通知  
payNotify=  
refundNotify=  
profitNotify=
 
# 路径
certPath=
```

> 作为普通商户配置文件
src/test/resources/standard.properties

```
# 商户配置  
appId=  
apiKey=  
aesKey=  
mchId=

# 通知  
payNotify=  
refundNotify=  
 
# 路径
certPath=
```

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

* 进件
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

* 转帐
    * 企业付款
    * 查询付款

# 联系 

winixi@qq.com
