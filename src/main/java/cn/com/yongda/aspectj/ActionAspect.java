package cn.com.yongda.aspectj;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class ActionAspect {
	private static final Logger logger = LoggerFactory
			.getLogger(ActionAspect.class);
	@Around("execution(public * cn.com.yongda.action.*.*.*(..)) || execution(public * cn.com.yongda.*.*(..))")
	public Object proceed(ProceedingJoinPoint joinPoint)throws Throwable{
		Object retVal = null;

        String methodName = joinPoint.getSignature().getName();
        Method targetMethod = null;

        Class targetClass = joinPoint.getTarget().getClass();
        for (Method method : targetClass.getMethods()) {
            if (method.getName().equals(methodName)) {
                targetMethod = method;
                break;
            }
        }

        if (null != targetMethod) {

            // 处理注解
//            handleAnnotations(targetMethod);
            Object[] args = joinPoint.getArgs();

            if (logger.isInfoEnabled()) {
                Map<String, String> tags =new HashMap<String, String>();
                if (null != args && args.length > 0) {
                    for (int i = 1; i <= args.length; i++) {
                        tags.put("param" + i, args[i - 1].toString());
                    }
                }
                logger.info("进入Action：{}", targetMethod.getName());
            }
            StopWatch watch = new StopWatch();
            watch.start();

            retVal = joinPoint.proceed(args);

            watch.stop();
            if (logger.isInfoEnabled()) {
                logger.info("退出Action：{}，耗时：{} ms", targetMethod.getName(), watch.getTime());
            }
        }

        return retVal;
	}
}
