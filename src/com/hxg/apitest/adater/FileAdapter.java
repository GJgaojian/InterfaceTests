package com.hxg.apitest.adater;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hxg.apitest.R;
import com.hxg.apitest.entity.FileEntity;

public class FileAdapter extends BaseAdapter {

	List<FileEntity> list;
	Context context;

	public FileAdapter(List<FileEntity> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	public List<FileEntity> getList() {
		return list;
	}

	public void setList(List<FileEntity> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public FileEntity getItem(int position) {
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
		Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
			holder.image = (ImageView) convertView
					.findViewById(R.id.image_icon);
			holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			convertView.setTag(holder);
		}
		holder = (Holder) convertView.getTag();

		holder.tv_name.setText(getItem(position).getName());
		if (getItem(position).isFile()) {
			holder.image.setImageResource(R.drawable.ic_ppt);
		} else {
			holder.image.setImageResource(R.drawable.ic_folder);
		}
		return convertView;
	}

	class Holder {
		TextView tv_name;
		ImageView image;
	}
}
