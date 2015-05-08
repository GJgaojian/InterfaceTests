package com.hxg.apitest.entity;

import java.io.Serializable;
import java.util.List;

public class APIListEntity implements Serializable {

	private List<APIEntity> list;

	public List<APIEntity> getList() {
		return list;
	}

	public void setList(List<APIEntity> list) {
		this.list = list;
	}
}
