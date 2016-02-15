package cn.com.yongda.exception;

import cn.com.yongda.common.enums.RetCodeEnum;

public class RetCodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261004405683218060L;
	private RetCodeEnum retCodeEnum;
	private String customMsg;
	public RetCodeException(RetCodeEnum retCodeEnum){
		super(retCodeEnum.getMessage());
		this.retCodeEnum = retCodeEnum;
	}
	public RetCodeException(RetCodeEnum retCodeEnum,String customMsg){
		super(customMsg);
		this.customMsg = customMsg;
		this.retCodeEnum = retCodeEnum;
	}
	public RetCodeEnum getRetCodeEnum() {
		return retCodeEnum;
	}
	public void setRetCodeEnum(RetCodeEnum retCodeEnum) {
		this.retCodeEnum = retCodeEnum;
	}
	public String getCustomMsg() {
		return customMsg;
	}
	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}
}
