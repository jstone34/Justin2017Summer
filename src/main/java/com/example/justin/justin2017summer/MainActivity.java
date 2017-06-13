package com.example.justin.justin2017summer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justin.justin2017summer.fragment.DemoFragment;
import com.example.justin.justin2017summer.fragment.WorkFragment;

public class MainActivity extends AppCompatActivity {

        private TextView tv_demo;
        private TextView tv_work;

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
                tv_work.setTextColor(Color.BLACK);
                tv_demo.setTextColor(Color.RED);

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
                tv_work.setTextColor(Color.RED);
                tv_demo.setTextColor(Color.BLACK);

                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment,workFragment).commit();
            }
        });
    }

    public void login(View v){
        Toast.makeText(MainActivity.this, "You Clicked Login", Toast.LENGTH_SHORT).show();
    }

    private void initialView() {
        tv_demo = (TextView)findViewById(R.id.activity_tool_demo);
        tv_work = (TextView)findViewById(R.id.activity_tool_work);
        WorkFragment workFragment = new WorkFragment();
        DemoFragment demoFragment = new DemoFragment();
    }


}
