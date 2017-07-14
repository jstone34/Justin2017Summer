package com.example.justin.justin2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity1 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("Data","Data");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }


}
