package com.example.vishwa.mandanmarlondonil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by vishwa on 4/5/18.
 */

public class Utill {

        public static boolean checkConnectivity(Context context){

            ConnectivityManager cm =(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activityNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activityNetwork != null && activityNetwork.isConnectedOrConnecting();
            return isConnected;
        }
}
