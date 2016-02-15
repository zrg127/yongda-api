package cn.com.yongda.action.helloworld;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yongda.action.BaseAction;
import cn.com.yongda.action.domain.BaseResponse;
import cn.com.yongda.action.request.HelloRequest;
import cn.com.yongda.common.enums.RetCodeEnum;
import cn.com.yongda.exception.RetCodeException;

@RestController
@RequestMapping("/hellworld")
public class SayHelloWorld extends BaseAction{
	@RequestMapping(value="/sayhai",method=RequestMethod.POST)
	@ResponseBody
	public Object sayHai(@Valid @RequestBody HelloRequest request){
		String result = "欢迎来到XXX的世界"+request.getName();
		return result;
	}
	@RequestMapping(value="/saygoodbye",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse<Object> sayGoodBye(@RequestBody HelloRequest request)throws Exception{
		BaseResponse<Object> result = new BaseResponse<Object>(RetCodeEnum.SUCCESS);
		if(true){
			throw new RetCodeException(RetCodeEnum.FAIL);
		}
		return result;
	}
}
