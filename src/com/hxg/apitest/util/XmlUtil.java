package com.hxg.apitest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.hxg.apitest.entity.APIEntity;

import android.util.Xml;

public class XmlUtil {

	public static List<APIEntity> parseXml(InputStream is) throws IOException, XmlPullParserException {

		List<APIEntity> list = null;
		APIEntity apiEntity = null;
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(is, "UTF-8");
		int event = parser.getEventType();

		while (event != XmlPullParser.END_DOCUMENT) {
			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				list = new ArrayList<APIEntity>();
				break;
			case XmlPullParser.START_TAG:
				switch (parser.getName()) {
				case "api":
					apiEntity = new APIEntity();
					break;
				case "url":
					apiEntity.setUrl(parser.nextText());
					break;
				case "method":
					apiEntity.setMethod(parser.nextText());
					break;
				case "params":
					apiEntity.setParams(parser.nextText());
					break;
				default:
					break;
				}
				break;
			case XmlPullParser.END_TAG:
				if ("api".equals(parser.getName())) {
					list.add(apiEntity);
					apiEntity = null;
				}
				break;
			}
			event = parser.next();
		}
		return list;
	}
}
