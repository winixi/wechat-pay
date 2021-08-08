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
public class TestStandardPayConfig implements PayConfig {

	private final static Logger logger = LoggerFactory.getLogger(TestStandardPayConfig.class);

	private String appId;
	private String apiKey;
	private String aesKey;
	private String certPath;
	private String mchId;
	private String payNotify;
	private String refundNotify;

	public TestStandardPayConfig() {
		InputStream in = this.getClass().getResourceAsStream("/standard.properties");
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
			Properties props = new Properties();
			props.load(inputStreamReader);
			appId = props.getProperty("appId");
			apiKey = props.getProperty("apiKey");
			aesKey = props.getProperty("aesKey");
			certPath = props.getProperty("certPath");
			mchId = props.getProperty("mchId");
			payNotify = props.getProperty("payNotify");
			refundNotify = props.getProperty("refundNotify");
		} catch (IOException e) {
			logger.error("读取配置错误", e);
		}
	}

	@Override
	public String getAppId() {
		return appId;
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
	public String getSubAppId() {
		return null;
	}

	@Override
	public String getProfitNotify() {
		return null;
	}

	@Override
	public String getSubscribeAppId() {
		return null;
	}

	@Override
	public String getFeeRate() {
		return null;
	}

}
