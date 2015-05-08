package com.hxg.apitest.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class GetUtil {

	public static String sendRequest(String path, String par) {

		StringBuilder sb = new StringBuilder(path);
		sb.append(par);
		// System.out.println(sb.toString()+"vvvvv");
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(sb.toString())
					.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			InputStream is = conn.getInputStream();
			if (conn.getResponseCode() == 200) {
				return StreamUtil.stream2String(is);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }
		return null;
	}
}
