package com.hxg.apitest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import com.hxg.apitest.adater.MyAdapter2;
import com.hxg.apitest.entity.APIEntity;
import com.hxg.apitest.util.XmlUtil;

public class MainActivity extends ActionBarActivity {

	Context context;
	ListView listView;
	MyAdapter2 myAdapter;
	List<APIEntity> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;

		Intent intent = getIntent();
		path = intent.getStringExtra("path");
		init();
	}

	private String path;

	private void init() {

		try {
			FileInputStream fos = new FileInputStream(new File(path));
			list = XmlUtil.parseXml(fos);
			for (APIEntity a : list) {
				System.out.println("```````½âÎöÊý¾Ý```````");
				System.out.println(a);
			}
			listView = (ListView) findViewById(R.id.listView);
			myAdapter = new MyAdapter2(context, list);
			listView.setAdapter(myAdapter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
