package com.hxg.apitest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class IndexActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
	}

	public void onClick(View view){
		if(checkNetWork(IndexActivity.this)){
			Intent intent = new Intent(IndexActivity.this, ChooseActivity.class);
			startActivity(intent);
		}else{
			Toast.makeText(IndexActivity.this, "当前网络未连接", 0).show();
		}
	}
	//检查当前网络是否可用
	private boolean checkNetWork(Context context){
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(cm == null){
			return false;
		}else{
			return cm.getActiveNetworkInfo().isAvailable();
		}
	}
}
