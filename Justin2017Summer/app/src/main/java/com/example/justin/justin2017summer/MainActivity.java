package com.example.justin.justin2017summer;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justin.justin2017summer.dialog.CustomDialog;
import com.example.justin.justin2017summer.dialog.Quiz3Dialog;
import com.example.justin.justin2017summer.fragment.DemoFragment;
import com.example.justin.justin2017summer.fragment.WorkFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

        private TextView tv_demo;
        private TextView tv_work;
        private Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        setListnerDemo();
        setListnerWork();
    }

    private void setListnerDemo() {
        final DemoFragment demoFragment = new DemoFragment();
        final WorkFragment workFragment = new WorkFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment,demoFragment).commit();

        tv_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_work.setTextColor(Color.BLUE);
                tv_demo.setTextColor(Color.WHITE);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment,demoFragment).commit();
            }
        });
    }

    private void setListnerWork() {
        final WorkFragment workFragment = new WorkFragment();
        final DemoFragment demoFragment = new DemoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment,workFragment).commit();

        tv_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_work.setTextColor(Color.WHITE);
                tv_demo.setTextColor(Color.BLUE);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment,workFragment).commit();
            }
        });
    }

    public void login(View v){
        Toast.makeText(MainActivity.this, "You Clicked Login", Toast.LENGTH_SHORT).show();
    }
    public void submit(View v){
        Toast.makeText(MainActivity.this, "You Clicked Submit", Toast.LENGTH_SHORT).show();
    }
    public void Quiz3(View v){
        Quiz3Dialog quiz3Dialog = new Quiz3Dialog(this);
        quiz3Dialog.setCanceledOnTouchOutside(true);
        quiz3Dialog.show();

    }

    public void Quiz5(View v){
      goToActivity(Quiz5Activity.class);
    }

    private void initialView() {
        tv_demo = (TextView)findViewById(R.id.activity_tool_demo);
        tv_work = (TextView)findViewById(R.id.activity_tool_work);
        WorkFragment workFragment = new WorkFragment();
        DemoFragment demoFragment = new DemoFragment();
    }


}
