package com.hxg.apitest.adater;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hxg.apitest.R;
import com.hxg.apitest.asyc.CheckApi;
import com.hxg.apitest.entity.APIEntity;

public class MyAdapter2 extends BaseAdapter{

	private Context context;
	private List<APIEntity> list;
	
	public MyAdapter2(Context context, List<APIEntity> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public APIEntity getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder ;
		if(convertView == null){
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
			holder.tv = (TextView) convertView.findViewById(R.id.tv_item);
			holder.tv_method = (TextView) convertView.findViewById(R.id.tv_item_method);
			holder.tv_params = (TextView) convertView.findViewById(R.id.tv_item_params);
			holder.tv_result = (TextView) convertView.findViewById(R.id.tv_item_result);
			holder.pb = (ProgressBar) convertView.findViewById(R.id.pb);
			convertView.setTag(holder);
		}
		holder = (Holder) convertView.getTag();
		
		new CheckApi(holder.pb).execute(list.get(position));
		this.notifyDataSetChanged();
		
		holder.tv.setText(getItem(position).getUrl());
		holder.tv_method.setText(getItem(position).getMethod());
		holder.tv_params.setText(getItem(position).getParams());
		holder.tv_result.setText(getItem(position).getResult());
		if(getItem(position).isFlag()){
			holder.tv.setTextColor(Color.GREEN);
			holder.tv_method.setTextColor(Color.GREEN);
			holder.tv_params.setTextColor(Color.GREEN);
			holder.tv_result.setTextColor(Color.GREEN);
		}else{
			holder.tv.setTextColor(Color.RED);
			holder.tv_method.setTextColor(Color.RED);
			holder.tv_params.setTextColor(Color.RED);
			holder.tv_result.setTextColor(Color.RED);
		}
		if(getItem(position).getState() == 2){
			holder.pb.setVisibility(View.GONE);
		}else{
			holder.pb.setVisibility(View.VISIBLE);
		}
		return convertView;
	}
	
	public class Holder{
		TextView tv,tv_method,tv_params,tv_result;
		ProgressBar pb;
	}
}
