package com.example.sampleapp1.Data;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sampleapp1.Constants;
import com.example.sampleapp1.Data.JsonModel.ImageF;
import com.example.sampleapp1.Data.JsonModel.ImageSinge;
import com.example.sampleapp1.Utilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{

    Context mContext;
    List<Image> mImageList = new ArrayList<>();
    static MutableLiveData<List<Image>> mImageLiveData = new MutableLiveData<>();

    public Repository(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public List<Image> getImages() {

        mImageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        mImageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));

        return mImageList;
    }


    public static MutableLiveData<List<Image>> createImageList(Context context) {
        String url = Constants.FLICKR_SEARCH_URL;

        MyVolleyRequestQueue.getInstance().getRequestQueue(context).add(new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        ImageF image = gson.fromJson(response.toString(), ImageF.class);
                   //     mImageList.add(image);

                        List<Image> imageList = new ArrayList<>();

                        Log.i("_MK_", response.toString());
                        Log.i("_MK_", (image.photos == null) ? "EMPTY" : "NON EMPTY");
                        Log.i("_MK_", (image.photos.photo.toString()));

                        for (ImageSinge singleImage : image.photos.photo) {
                            String imageUrl = Utilities.createFlickrImageUrl(singleImage.farm, singleImage.server, singleImage.id, singleImage.secret);
                            imageList.add(new Image(imageUrl));
                        }

                        mImageLiveData.setValue(imageList);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("_MK_", error.toString());

                    }
                }

        ));

        return mImageLiveData;
    }



}
