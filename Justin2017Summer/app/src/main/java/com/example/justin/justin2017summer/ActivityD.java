package com.example.justin.justin2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.OnClick;

public class ActivityD extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        shortToast("OnCreate");
    }

    public void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        shortToast("OnNewIntent");
    }

    public void ActivityA(View v){
        goToActivity(ActivityA.class);
    }
    public void ActivityB(View v){
        goToActivity(ActivityB.class);
    }
    public void ActivityC(View v){
        goToActivity(ActivityC.class);
    }
    public void ActivityD(View v){
        goToActivity(ActivityD.class);
    }
}
