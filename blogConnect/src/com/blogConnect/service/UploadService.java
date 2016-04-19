package com.blogConnect.service;


import java.lang.ref.WeakReference;

import com.blogConnect.model.Constants;

import com.blogConnect.model.ImageResponse;
import com.blogConnect.model.ImgurAPI;
import com.blogConnect.model.UiCallback;
import com.blogConnect.model.Upload;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;
import com.blogConnect.controller.*;
/**
 * Created by AKiniyalocts on 1/12/15.
 * <p/>
 * Our upload service. This creates our restadapter, uploads our image, and notifies us of the response.
 */
public class UploadService {
	
/*    public final static String TAG = UploadService.class.getSimpleName();

    private WeakReference<Context> mContext;

    public UploadService(Context context) {
        this.mContext = new WeakReference<>(context);
    }
*/
	
	public static String responseResult="";
	
    public void Execute(Upload upload, Callback<ImageResponse> callback) { 
        final Callback<ImageResponse> cb = callback;
        //final UiCallback cb = (UiCallback) callback;
        RestAdapter restAdapter = buildRestAdapter();

        restAdapter.create(ImgurAPI.class).postImage(
                Constants.getClientAuth(),
                upload.title,
                upload.description,
                upload.albumId,
                null,
                new TypedFile("image/*", upload.image),
            
                new Callback<ImageResponse>() {
                    @Override
                    
                    
                    public void success(ImageResponse imageResponse, Response response) { 
                       if (cb != null) cb.success(imageResponse, response);
                        if (response == null) {
                        
                        	
                        	responseResult="fail";
                            return; 
                        }
                    
                        
                        if (imageResponse.success) {
                        	
                        	System.out.println("sucess: "+imageResponse.success);
                        	System.out.println(imageResponse.data.link);
                        	 responseResult=imageResponse.data.link;
                        	
                        	 
                        	 setResponseResult(responseResult);
                        	 
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (cb != null) cb.failure(error);

                        responseResult="fail";
                    }
                });
        
    }
    
    
    public void  setResponseResult(String responseResult){
    	this.responseResult=responseResult;
    }
    
    private RestAdapter buildRestAdapter() {
        RestAdapter imgurAdapter = new RestAdapter.Builder().setServer(ImgurAPI.server).build();
        //new RestAdapter.Builder().
        
       /* Set rest adapter logging if we're already logging
*/        
        if (Constants.LOGGING)
            imgurAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return imgurAdapter;
    }
}