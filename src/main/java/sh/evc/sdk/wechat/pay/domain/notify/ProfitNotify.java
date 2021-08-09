package sh.evc.sdk.wechat.pay.domain.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import sh.evc.sdk.wechat.pay.response.XmlResponse;

/**
 * 分账通知
 *
 * @author winixi@qq.com
 * @date 2021/8/9 11:33 PM
 */
@JacksonXmlRootElement(localName = "xml")
public class ProfitNotify extends XmlResponse {

	/**
	 * 服务商的appId
	 */
	@JsonProperty("appid")
	private String appId;

}
