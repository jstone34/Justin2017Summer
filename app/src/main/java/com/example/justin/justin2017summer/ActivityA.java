package com.example.justin.justin2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;

public class ActivityA extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toast.makeText(this, "onCreate",Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);
    }



}
