package com.example.miprimerapp2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DetectarInternet {
    Context context;
    public boolean hayConexionInternet() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) return false;

        NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
        if (info == null) return false;

        for (int i = 0; i < info.length; i++) {
            if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }
}
