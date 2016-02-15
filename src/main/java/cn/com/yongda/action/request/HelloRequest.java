package cn.com.yongda.action.request;

import java.io.Serializable;

public class HelloRequest implements Serializable{
	private static final long serialVersionUID = 1930939713997154867L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
