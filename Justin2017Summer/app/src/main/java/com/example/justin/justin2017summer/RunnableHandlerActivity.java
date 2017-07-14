package com.example.justin.justin2017summer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RunnableHandlerActivity extends BaseActivity {

    @BindView(R.id.activity_runnable_handler_et)
    EditText editText;

    @BindView(R.id.activity_runnable_handler_btn)
    Button button;

    private View.OnClickListener startListner;
    private View.OnClickListener stopListner;
    private View.OnClickListener resetListner;
    private Thread thread;

    Handler handler = new Handler();
    private int time =0;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if (time>=0){
                editText.setText(String.valueOf(time));
                handler.postDelayed(runnable,1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable_handler);
        ButterKnife.bind(this);

        startListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Stop");
                editText.setEnabled(false);
                button.setOnClickListener(stopListner);
                time = Integer.valueOf(editText.getText().toString());
                handler.postDelayed(runnable,1000);
            }

        };

        stopListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Reset");
                button.setOnClickListener(resetListner);
                handler.removeCallbacks(runnable);
            }
        };

        resetListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Start");
                editText.setEnabled(true);
                button.setOnClickListener(startListner);
            }
        };

        button.setOnClickListener(startListner);
    }
}
