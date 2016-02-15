package cn.com.yongda.common.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class TraceConverter extends ClassicConverter {

	@Override
	public String convert(ILoggingEvent arg0) {
		return null==Trace.getTraceId()?"":Trace.getTraceId();
	}

}
