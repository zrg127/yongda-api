package cn.com.yongda.common.enums;

public enum RetCodeEnum {
	SUCCESS(0, "处理正常"),
	AGENT_ERROR(2, "头部请求参数异常"),
	FAIL(9999,"请求失败");
	private int retcode;
	private String message;

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	RetCodeEnum(int retcode, String message) {
		this.retcode=retcode;
		this.message = message;
	}
}
