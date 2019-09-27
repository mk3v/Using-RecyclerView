package com.example.sampleapp1.Data;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyVolleyRequestQueue {

    static MyVolleyRequestQueue mInstance = new MyVolleyRequestQueue();
    private RequestQueue requestQueue = null;

    private MyVolleyRequestQueue() {
    }

    public static MyVolleyRequestQueue getInstance(){

        return mInstance;
    }

    public RequestQueue getRequestQueue(Context context){
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }


}
