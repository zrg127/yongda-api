package cn.com.yongda.common.log;

import java.util.UUID;

public class Trace {
	private static ThreadLocal<String> TraceTL = new ThreadLocal<String>();
	private Trace(){
		throw new AssertionError("该Class不能实例化");
	}
	public static String getTraceId(){
		return TraceTL.get();
	}
	public static void start(){
		TraceTL.set(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
	}
	public static void stop(){
		TraceTL.remove();
	}
}
