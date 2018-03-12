package com.example.jameskaviyiljose.volleytwo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by James Kaviyil Jose on 3/12/2018.
 */

public class mySingleton {
    private static mySingleton myInstance;
    private RequestQueue requestQueue;
    private static Context mycontext;

    private mySingleton(Context context){
        mycontext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(mycontext.getApplicationContext());
        return requestQueue;
    }

    public static synchronized mySingleton getMyInstance(Context context){
        if(myInstance == null){
            myInstance = new mySingleton(context);
        }
        return myInstance;

    }


    public void addToRequestQueue(Request request){
        requestQueue.add(request);
    }
}
