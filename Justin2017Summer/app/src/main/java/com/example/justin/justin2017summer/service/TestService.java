package com.example.justin.justin2017summer.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Justin on 7/3/2017.
 */

public class TestService extends Service {

    private Timer timer = new Timer();
    private int update =0;
    public static final String UPDATE = "update";
    public static String ACTION = "TestAction";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String value = intent.getStringExtra("Service");
        timer.schedule(new UpdateTask(), 0, 1000);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        timer.schedule(new UpdateTask(), 0, 0000);
        return super.stopService(name);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class UpdateTask extends TimerTask{
        public void run(){
            Intent intent = new Intent();
            intent.setAction(ACTION);
            intent.putExtra(UPDATE, ++update);
            sendBroadcast(intent);

        }
    }
}
