package cn.com.yongda.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.yongda.common.log.LogFormatter;
import cn.com.yongda.common.log.Trace;
import cn.com.yongda.common.util.ContextManager;
import cn.com.yongda.common.util.HttpUtil;

public class GlobalFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(GlobalFilter.class);
	private static String SERVER_IP;
	private static String SERVER_NAME;
	static {
		try {
			SERVER_IP = InetAddress.getLocalHost().getHostAddress();
			SERVER_NAME = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException ex) {
			logger.warn("{} {}", "System", ex);
			SERVER_IP = "UNKNOWN";
			SERVER_NAME = "UNKNOWN";
		}
	}
	private String[] ignore = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ignore = filterConfig.getInitParameter("ignore").split(";");
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterConfig)
			throws IOException, ServletException {
		doIngoreFilter(servletRequest, servletResponse, filterConfig);
	}

	private void doIngoreFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterConfig)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		defaultFilter(httpServletRequest, servletResponse, filterConfig);
	}

	private void defaultFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain) {
		Trace.start();
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		// 设置Context
		ContextManager.setMobileAgent(HttpUtil
				.parseMoblieAgent(httpServletRequest));
		ContextManager.setUri(MessageFormat.format("{0}",
				httpServletRequest.getRequestURI()));
		// 记录客户端信息
		Map<String, String> tags = new HashMap<String, String>();
		tags.put("uri", ContextManager.getUri());
		tags.put("OS", ContextManager.getMobileAgent().getOs());
		tags.put("customOS", ContextManager.getMobileAgent().getCustomOs());
		tags.put("isp", ContextManager.getMobileAgent().getIsp());
		tags.put("model", ContextManager.getMobileAgent().getModel());
		tags.put("appVersion", ContextManager.getMobileAgent().getAppVersion());
		tags.put("clientIP", ContextManager.getMobileAgent().getClientIp());
		logger.info(LogFormatter.formatWithTags("请求开始{}", tags),
				ContextManager.getUri());
		try {
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception ex) {
			logger.error(LogFormatter.formatWithTags("请求处理异常", tags), ex);
		}finally {
			// 释放Context
			ContextManager.removeMobileAgent();
			ContextManager.removeUri();
			logger.info(LogFormatter.formatWithTags("请求结束", tags));
			Trace.stop();
		}
	}

	@Override
	public void destroy() {

	}
}
