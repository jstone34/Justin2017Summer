package com.example.justin.justin2017summer;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.justin.justin2017summer.adapter.ScalePagerAdapter;

import java.util.ArrayList;

public class ActivityC extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
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
    public void ActivityC(View v){  goToActivity(ActivityC.class);}
    public void ActivityD(View v){
        goToActivity(ActivityD.class);
    }

}
