package cn.com.yongda.action.domain;

import java.io.Serializable;

import cn.com.yongda.common.enums.RetCodeEnum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3575788133301682903L;
	/** 返回码 **/
	private int retCode;
	/** 返回码信息 **/
	private String message;
	/** 业务数据 **/
	private T body;

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	public BaseResponse(RetCodeEnum retCodeEnum){
		this.fillRetCodeEnum(retCodeEnum);
	}
	public BaseResponse(){
		
	}
	public void fillRetCodeEnum(RetCodeEnum retCodeEnum){
		this.retCode =retCodeEnum.getRetcode();
		this.message=retCodeEnum.getMessage();
	}
}
