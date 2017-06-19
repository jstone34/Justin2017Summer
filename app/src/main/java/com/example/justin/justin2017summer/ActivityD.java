package com.example.justin.justin2017summer;

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
        Toast.makeText(this, "Activity D",Toast.LENGTH_SHORT).show();
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
