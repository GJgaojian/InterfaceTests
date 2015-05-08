package com.hxg.apitest.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostUtil {

public static String sendPostAndGetInfo(String path,String str){
		
		
		byte[] buffer = str.getBytes();
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(buffer);
			os.flush();
			if(conn.getResponseCode() == 200){
				InputStream is = conn.getInputStream();
				return StreamUtil.stream2String(is);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
