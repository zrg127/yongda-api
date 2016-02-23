package cn.com.yongda.repository.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GatewayItf {
	private String itfId;
	private String itfName;
	private String itfType;
	private String gmtCreate;
	private String gmtModified;
	private String remark;
	public String getItfId() {
		return itfId;
	}
	public void setItfId(String itfId) {
		this.itfId = itfId;
	}
	public String getItfName() {
		return itfName;
	}
	public void setItfName(String itfName) {
		this.itfName = itfName;
	}
	public String getItfType() {
		return itfType;
	}
	public void setItfType(String itfType) {
		this.itfType = itfType;
	}
	public String getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public String getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
