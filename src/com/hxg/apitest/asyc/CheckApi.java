package com.hxg.apitest.asyc;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import com.hxg.apitest.entity.APIEntity;
import com.hxg.apitest.util.GetUtil;
import com.hxg.apitest.util.PostUtil;

public class CheckApi extends AsyncTask<APIEntity, Integer, String>{

	ProgressBar pb;
	
	public CheckApi(ProgressBar pb) {
		super();
		this.pb = pb;
	}

	@Override
	protected String doInBackground(APIEntity... apiEntity) {
		// TODO Auto-generated method stub
		String strr = null;
		if (apiEntity[0].getMethod().equalsIgnoreCase("post")) {
			System.out.println("`````post");
			strr = PostUtil.sendPostAndGetInfo(apiEntity[0].getUrl(),
					apiEntity[0].getParams());
		} else {
			System.out.println("``````get");
			strr = GetUtil.sendRequest(apiEntity[0].getUrl(),
					apiEntity[0].getParams());
		}
		if(strr!=null){
			apiEntity[0].setResult(strr);
			apiEntity[0].setFlag(true);
		}
		apiEntity[0].setState(2);
		return strr;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		pb.setVisibility(View.GONE);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

}
