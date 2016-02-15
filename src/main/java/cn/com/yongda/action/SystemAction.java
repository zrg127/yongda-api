package cn.com.yongda.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yongda.action.domain.BaseResponse;
import cn.com.yongda.common.enums.RetCodeEnum;
@RestController
public class SystemAction {
	@RequestMapping(value="/error/agent-error")
	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
	public BaseResponse<Object> moblieAgentError(){
		return new BaseResponse<Object>(RetCodeEnum.AGENT_ERROR);
	} 
	@RequestMapping(value = "/error")
    public BaseResponse<Object> error(HttpServletRequest request, HttpServletResponse response) {
		BaseResponse<Object> restResponse = new BaseResponse<Object>();
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        restResponse.setRetCode(statusCode);
        restResponse.setMessage("请查看status说明");
        return restResponse;
    }
}
