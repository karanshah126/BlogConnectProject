package com.blogConnect.model;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UiCallback implements Callback<ImageResponse>{
	public String url;
	@Override
	public void failure(RetrofitError arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void success(ImageResponse arg0, Response arg1) {
		// TODO Auto-generated method stub
		url = arg0.data.link;
	}
	public void setUrl(String url){
		this.url = url;
	}
}
