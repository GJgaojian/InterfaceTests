package com.hxg.apitest.util;

import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {

	public static String stream2String(InputStream is) throws IOException{
		byte[] buffer = new byte[1024];
		int len = 0;
		StringBuffer sb = new StringBuffer();
		while((len = is.read(buffer))!=-1){
			sb.append(new String(buffer,0,len));
		}
		return sb.toString();
	}
}
