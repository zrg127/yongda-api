package cn.com.yongda.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.yongda.action.domain.MobileAgent;
import cn.com.yongda.exception.AgentException;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * Http工具类
 *
 * @author zzs
 * @date 2016/2/4
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 从Http Header中解析出X-Mobile-Agent
     * X-Mobile-Agent的格式是由7部分组成: IMEI;IMES;操作系统名称和版本;订制系统名称和版本;网络运行商;手机型号;渠道编号;APP版本
     *
     * @param httpServletRequest
     * @return X-Mobile-Agent
     * @throws IllegalArgumentException
     */
    public static MobileAgent parseMoblieAgent(HttpServletRequest httpServletRequest) throws IllegalArgumentException {
        String kjtAgent = httpServletRequest.getHeader(CommonConstant.HEADER_AGENT_KEY);

        if (StringUtils.isEmpty(kjtAgent)) {
            logger.error("X-Moblie-Agent");
            throw new AgentException("X-Moblie-Agent");
        }

        List<String> parts = Lists.newArrayList(Splitter.on(";").trimResults().split(kjtAgent));

        String appVersion;
        switch (parts.size()) {
            // 兼容旧版本
            case 7:
                appVersion = "1.0";
                break;
            case 8:
                appVersion = parts.get(7);
                break;
            default:
                logger.error("X-Moblie-Agent格式错误", kjtAgent);
                throw new AgentException("X-Moblie-Agent格式错误");
        }

        return new MobileAgent(parts.get(0), parts.get(1), parts.get(2), parts.get(3), parts.get(4), parts.get(5), parts.get(6),
                getClientIp(httpServletRequest), appVersion);
    }
    
    /**
     * 取得客户端IP地址<br>
     * 
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("H5-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
