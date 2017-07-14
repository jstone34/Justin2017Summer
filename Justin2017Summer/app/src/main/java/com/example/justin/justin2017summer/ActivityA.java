package com.example.justin.justin2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.justin.justin2017summer.audio.BaseBean;

import butterknife.ButterKnife;

public class ActivityA extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        shortToast("OnCreate");
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        BaseBean bean = (BaseBean) bundle.getSerializable("Object");
        String bs = bundle.getString("StringBundle");
        int bi = bundle.getInt("IntegerBundle",0);
        shortToast(bs);
        shortToast(bi+"");
        shortToast(bean.getName());
      /*  String s = intent.getStringExtra("StringInfo");
        int i = intent.getIntExtra("IntegerInfo", 0);
        shortToast(s);
        shortToast(i+"");
        shortToast("Integer is: "+i);*/
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
