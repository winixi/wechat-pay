package sh.evc.sdk.wechat.pay.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 测试配置
 *
 * @author winixi
 * @date 2021/1/21 4:43 PM
 */
public class TestServicePayConfig implements PayConfig {

	private final static Logger logger = LoggerFactory.getLogger(TestServicePayConfig.class);

	private String appId;
	private String mchId;
	private String subAppId;
	private String apiKey;
	private String aesKey;
	private String certPath;
	private String payNotify;
	private String refundNotify;
	private String profitNotify;
	private String subscribeAppId;
	private String feeRate;

	public TestServicePayConfig() {
		InputStream in = this.getClass().getResourceAsStream("/service.properties");
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
			Properties props = new Properties();
			props.load(inputStreamReader);
			appId = props.getProperty("appId");
			mchId = props.getProperty("mchId");
			subAppId = props.getProperty("subAppId");
			apiKey = props.getProperty("apiKey");
			aesKey = props.getProperty("aesKey");
			certPath = props.getProperty("certPath");
			payNotify = props.getProperty("payNotify");
			refundNotify = props.getProperty("refundNotify");
			profitNotify = props.getProperty("profitNotify");
			subscribeAppId = props.getProperty("subscribeAppId");
			feeRate = props.getProperty("feeRate");
		} catch (IOException e) {
			logger.error("读取配置错误", e);
		}
	}

	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public String getSubAppId() {
		return subAppId;
	}

	@Override
	public String getApiKey() {
		return apiKey;
	}

	@Override
	public String getAesKey() {
		return aesKey;
	}

	@Override
	public String getCertPath() {
		return certPath;
	}

	@Override
	public String getMchId() {
		return mchId;
	}

	@Override
	public String getPayNotify() {
		return payNotify;
	}

	@Override
	public String getRefundNotify() {
		return refundNotify;
	}

	@Override
	public String getProfitNotify() {
		return profitNotify;
	}

	@Override
	public String getSubscribeAppId() {
		return subscribeAppId;
	}

	@Override
	public String getFeeRate() {
		return feeRate;
	}
}
