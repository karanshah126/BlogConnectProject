package com.blogConnect.service;


import com.blogConnect.model.Constants;

import com.blogConnect.model.ImageResponse;
import com.blogConnect.model.ImgurAPI;
import com.blogConnect.model.Upload;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class UploadService {
	

	
	public static String responseResult="";
	
    public String Execute(Upload upload, Callback<ImageResponse> callback) { 
        final Callback<ImageResponse> cb = callback;
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
                        	
                        	 
                        	
                        	 
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (cb != null) cb.failure(error);

                        responseResult="fail";
                    }
                    
                  
                });
   
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return responseResult;
        
    }
    
    
  
    
    private RestAdapter buildRestAdapter() {
        RestAdapter imgurAdapter = new RestAdapter.Builder().setServer(ImgurAPI.server).build();
      
        if (Constants.LOGGING)
            imgurAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return imgurAdapter;
    }
}