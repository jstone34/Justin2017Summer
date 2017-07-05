package com.example.justin.justin2017summer;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.justin.justin2017summer.controller.TestAudioController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestAudioActivity extends BaseActivity {

    private TestAudioController controller;
    private String AudioURL = "http://other.web.rh01.sycdn.kuwo.cn/resource/n3/77/1/1061700123.mp3";

    @BindView(R.id.activity_test_audio_play)
    Button playbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_audio);
        ButterKnife.bind(this);
        controller = new TestAudioController(this);

    }
}
