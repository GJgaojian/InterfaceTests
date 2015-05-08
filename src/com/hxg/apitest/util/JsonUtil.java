package com.hxg.apitest.util;

import java.io.InputStream;

import com.google.gson.Gson;
import com.hxg.apitest.entity.APIEntity;
import com.hxg.apitest.entity.APIListEntity;

public class JsonUtil {

	public static APIEntity parseJson(String json){
		return new Gson().fromJson(json, APIEntity.class);
	}
	
	public static APIListEntity parse2Json(String json){
		return new Gson().fromJson(json, APIListEntity.class);
	}
}
