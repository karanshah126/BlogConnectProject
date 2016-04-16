package com.blogConnect.service;


import java.lang.ref.WeakReference;

import com.blogConnect.model.Constants;

import com.blogConnect.model.ImageResponse;
import com.blogConnect.model.ImgurAPI;
import com.blogConnect.model.Upload;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

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
	
	String responseResult="";
	
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
                     /*       
                             Notify image was NOT uploaded successfully
                            
                            notificationHelper.createFailedUploadNotification();*/
                        	responseResult="fail";
                            return;
                        }
                        /*
                        Notify image was uploaded successfully
                        */
                        if (imageResponse.success) {
                           // notificationHelper.createUploadedNotification(imageResponse);
                        	 responseResult=imageResponse.data.link;
                        	
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (cb != null) cb.failure(error);
                        /*notificationHelper.createFailedUploadNotification();*/
                        responseResult="fail";
                    }
                });
        return responseResult;
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