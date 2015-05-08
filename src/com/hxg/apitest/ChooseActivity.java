package com.hxg.apitest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.hxg.apitest.adater.FileAdapter;
import com.hxg.apitest.entity.FileEntity;

public class ChooseActivity extends ActionBarActivity {

	private GridView gv;
	private List<FileEntity> list;
	private Context context;
	private FileAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose);
		context = this;

		gv = (GridView) findViewById(R.id.gv);
		File root = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath());

		list = getFileList(root);
		adapter = new FileAdapter(list, context);
		gv.setAdapter(adapter);
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(!adapter.getList().get(position).isFile()){
					Intent intent = new Intent(ChooseActivity.this,MainActivity.class);
					intent.putExtra("path", adapter.getList().get(position).getPath());
					startActivity(intent);
				}else{
					list = getFileList(new File(adapter.getList().get(position).getPath()));
					adapter.setList(list);
					adapter.notifyDataSetChanged();
				}
			}
		});
	}

	//获得当前目录下的文件列表
	private List getFileList(File file) {
		List<FileEntity> list = new ArrayList<FileEntity>();
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains(".xml")) {
				list.add(new FileEntity(files[i].getName(), files[i].getPath(),
						files[i].isDirectory()));
			}
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				list.add(new FileEntity(files[i].getName(), files[i].getPath(),
						files[i].isDirectory()));
			}
		}
		return list;
	}

}
