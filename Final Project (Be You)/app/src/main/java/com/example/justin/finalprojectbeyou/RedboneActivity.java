package com.example.justin.finalprojectbeyou;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

import butterknife.ButterKnife;

public class RedboneActivity extends BaseActivity {
    final MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_slide);
        String url = "http://purplinx.org/985jrvgucspt/play.mp3"; // your URL here

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        final ImageView play = (ImageView) findViewById(R.id.slideplay);
        final ImageView stop = (ImageView) findViewById(R.id.slidestop);
        final ImageView home = (ImageView) findViewById(R.id.slidebacktoprofile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(FeedActivity.class);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                play.setVisibility(View.INVISIBLE);
                stop.setVisibility(View.VISIBLE);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setVisibility(View.VISIBLE);
                stop.setVisibility(View.INVISIBLE);
                mediaPlayer.pause();
            }
        });
    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }
}
