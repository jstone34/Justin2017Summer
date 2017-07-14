package com.example.justin.finalprojectbeyou.musicDialog;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.example.justin.finalprojectbeyou.FeedActivity;
import com.example.justin.finalprojectbeyou.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Justin on 6/21/2017.
 */

public class MusicDialog extends Dialog {
    final MediaPlayer mediaPlayer = new MediaPlayer();

    public interface iCustomDialogListener{
        public void onOKClicked(String msg);
    }

    public MusicDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.music_dialog);
        ButterKnife.bind(this);
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
        final ImageView play = (ImageView) findViewById(R.id.dialogplay);
        final ImageView stop = (ImageView) findViewById(R.id.dialogstop);
        final ImageView close = (ImageView) findViewById(R.id.redclose);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                cancel();
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
}
