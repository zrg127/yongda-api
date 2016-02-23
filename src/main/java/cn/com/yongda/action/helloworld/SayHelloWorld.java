package cn.com.yongda.action.helloworld;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import cn.com.yongda.action.BaseAction;
import cn.com.yongda.action.domain.BaseResponse;
import cn.com.yongda.action.request.HelloRequest;
import cn.com.yongda.common.enums.RetCodeEnum;
import cn.com.yongda.exception.RetCodeException;
import cn.com.yongda.repository.dao.GatewayItfDao;
import cn.com.yongda.repository.entity.GatewayItf;

@RestController
@RequestMapping("/hellworld")
public class SayHelloWorld extends BaseAction{
	private  Logger logger = (Logger) LoggerFactory.getLogger(SayHelloWorld.class);
	@Autowired
	private GatewayItfDao  gatewayItfDao;
	@RequestMapping(value="/sayhai",method=RequestMethod.POST)
	@ResponseBody
	public Object sayHai(@Valid @RequestBody HelloRequest request){
		GatewayItf userInfo = null;
		try {
			userInfo =gatewayItfDao.queryGatewayItf(request.getName());
		} catch (Exception e) {
			logger.info("异常信息",e);
		}
		
		
		String result = "欢迎来到XXX的世界"+userInfo.toString();
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
