package cn.com.yongda.action.domain;
/**
 * 
 *手机硬件信息
 */
public class MobileAgent {
	/**
     * 手机IMEI
     */
    private String imei;
    /**
     * 手机IMES编号
     */
    private String imes;
    /**
     * 操作系统名称及版本
     */
    private String os;
    /**
     * 订制操作系统名称及版本
     */
    private String customOs;
    /**
     * 网络运营商
     */
    private String isp;
    /**
     * 手机型号
     */
    private String model;
    /**
     * 区号编号
     */
    private String channel;
    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * App版本
     */
    private String appVersion;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImes() {
		return imes;
	}

	public void setImes(String imes) {
		this.imes = imes;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCustomOs() {
		return customOs;
	}

	public void setCustomOs(String customOs) {
		this.customOs = customOs;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public MobileAgent(String imei, String imes, String os, String customOs, String isp, String model, String channel, String clientIp, String appVersion){
		this.imei = imei;
        this.imes = imes;
        this.os = os;
        this.customOs = customOs;
        this.isp = isp;
        this.model = model;
        this.channel = channel;
        this.clientIp = clientIp;
        this.appVersion = appVersion;
	}
	@Override
	public String toString() {
		return "MobileAgent [imei=" + imei + ", imes=" + imes + ", os=" + os
				+ ", customOs=" + customOs + ", isp=" + isp + ", model="
				+ model + ", channel=" + channel + ", clientIp=" + clientIp
				+ ", appVersion=" + appVersion + "]";
	}
}
