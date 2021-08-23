package sh.evc.sdk.wechat.pay.dict;

/**
 * 转帐状态
 *
 * @author winixi
 * @date 2021/2/17 10:25 PM
 */
public enum TransferStatus {

	UNDO("未执行"),
	PROCESSING("处理中"),
	SUCCESS("转账成功"),
	FAILED("转账失败");

	private String value;

	TransferStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
