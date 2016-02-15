package cn.com.yongda.common.log;

import java.util.Map;
/**
 * 
 * 打印日志格式化
 *
 */
public class LogFormatter {
	private LogFormatter(){
		throw new AssertionError("该类不能实例化");
	}
	public static String formatWithTags(String pattern, Map<String, String> tags){
		return String.format("%s <! %s !>", pattern,normalizeTags(tags));
	}
	private static String normalizeTags(Map<String, String> tags){
		if(tags==null||tags.size()==0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, String> entry:tags.entrySet()){
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
}
