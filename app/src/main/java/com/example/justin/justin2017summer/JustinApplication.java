package com.example.justin.justin2017summer;

import android.app.Application;

import com.example.justin.justin2017summer.util.UtilLog;

/**
 * Created by Justin on 6/19/2017.
 */

public class JustinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }
}
