package com.example.justin.justin2017summer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.justin.justin2017summer.service.TestService;

import junit.framework.Test;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.activity_service_tv)
    TextView textView;
    private TestReceiver testReceiver;

    @OnClick(R.id.activity_service_btn)
    public void startService(View v){
        TestService.ACTION = "TestAction";
        Intent intent = new Intent(this, TestService.class);
        intent.putExtra("Service", "Start");
        startService(intent);
        registerBroadcast();
    }

    @OnClick(R.id.activity_service_stop_btn)
    public void stopService(View v){
       TestService.ACTION = null;
    }

    private void registerBroadcast() {
        testReceiver = new TestReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TestService.ACTION);
        registerReceiver(testReceiver,filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }
    
    public class TestReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(TestService.ACTION)){
                int update = intent.getIntExtra("update",0);
                textView.setText(String.valueOf(update));
            }
            else {
                textView.setText("Waiting");
            }
        }

    }
}
