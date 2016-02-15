package cn.com.yongda.common.util;

import cn.com.yongda.action.domain.MobileAgent;

/**
 * 
 * 线程内全局属性管理器
 *
 */
public class ContextManager {
	private static final ThreadLocal<String> uriThreadLocal = new ThreadLocal<String>();
	private static final ThreadLocal<MobileAgent> mobileAgentThreadLocal = new ThreadLocal<MobileAgent>();
	/**
	 * 设置当前线程的MobileAgent
	 * @param mobileAgent
	 */
	public static void setMobileAgent(MobileAgent mobileAgent){
		mobileAgentThreadLocal.set(mobileAgent);
	}
	/**
	 * 获取当前线程MobileAgent
	 * @return
	 */
	public static MobileAgent getMobileAgent(){
		return mobileAgentThreadLocal.get();
	}
	/**
	 * 移除当前线程MobileAgent
	 */
	public static void removeMobileAgent(){
		mobileAgentThreadLocal.remove();
	}
	/**
	 * 
	 * 设置当前线程的uri
	 */
	public static void setUri(String uri){
		uriThreadLocal.set(uri);
	}
	/**
	 * 
	 * 获取当前线程的uri
	 */
	public static String getUri(){
		return uriThreadLocal.get();
	}
	/**
	 * 移除当前线程的uri
	 */
	public static void removeUri(){
		uriThreadLocal.remove();
	}
}
