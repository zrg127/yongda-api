package cn.com.yongda.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.com.yongda.action.domain.BaseResponse;
import cn.com.yongda.exception.RetCodeException;

public class BaseAction {
	@ExceptionHandler(RetCodeException.class)
	@ResponseStatus(value=HttpStatus.OK)
	public BaseResponse handleRetCodeException(RetCodeException retCodeException){
		BaseResponse<String> response = new BaseResponse<String>();
		response.fillRetCodeEnum(retCodeException.getRetCodeEnum());
		if(StringUtils.isNotEmpty(retCodeException.getCustomMsg())){
			response.setMessage(retCodeException.getCustomMsg());
		}
		return response;
	}
}
