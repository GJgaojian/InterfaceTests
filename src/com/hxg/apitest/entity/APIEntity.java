package com.hxg.apitest.entity;

import java.io.Serializable;

public class APIEntity implements Serializable {

	//aip路径
	private String url;
	//请求方式
	private String method;
	//请求参数
	private String params;
	//是否成功
	private boolean flag;
	//请求结果
	private String result;
	//测试状态码：1正在测试、2测试完成
	private int state; 
	
	public APIEntity() {
		super();
		state = 1;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "APIEntity [url=" + url + ", method=" + method + ", params="
				+ params + "]";
	}
}
