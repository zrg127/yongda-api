package cn.com.yongda.repository.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8875604492216472108L;
	private String yongdaName;
	private String yongdaAge;
	private String yongdaAgree;
	private String yongdaClass;
	private String remark;
	public String getYongdaName() {
		return yongdaName;
	}
	public void setYongdaName(String yongdaName) {
		this.yongdaName = yongdaName;
	}
	public String getYongdaAge() {
		return yongdaAge;
	}
	public void setYongdaAge(String yongdaAge) {
		this.yongdaAge = yongdaAge;
	}
	public String getYongdaAgree() {
		return yongdaAgree;
	}
	public void setYongdaAgree(String yongdaAgree) {
		this.yongdaAgree = yongdaAgree;
	}
	public String getYongdaClass() {
		return yongdaClass;
	}
	public void setYongdaClass(String yongdaClass) {
		this.yongdaClass = yongdaClass;
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
