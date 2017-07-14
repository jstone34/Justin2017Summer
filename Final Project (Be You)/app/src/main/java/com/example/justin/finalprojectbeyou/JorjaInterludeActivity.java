package com.example.justin.finalprojectbeyou;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class JorjaInterludeActivity extends BaseActivity {
    final MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_jorja_interlude);
        String url = "https://www.stuffdown.com/2017/Drake%20-%20More%20Life%20-%20(www.SongsLover.club)/04.%20Jorja%20Interlude%20-%20(www.SongsLover.club).mp3"; // your URL here

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
        final ImageView play = (ImageView) findViewById(R.id.jorjaplay);
        final ImageView stop = (ImageView) findViewById(R.id.jorjastop);
        final ImageView home = (ImageView) findViewById(R.id.backtoprofile);

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
