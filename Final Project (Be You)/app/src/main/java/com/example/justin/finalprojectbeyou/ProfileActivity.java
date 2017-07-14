package com.example.justin.finalprojectbeyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.justin.finalprojectbeyou.musicDialog.MusicDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends BaseActivity {


    @OnClick(R.id.activity_profile_feed_btn)
    public void feed (View v){
        goToActivity(FeedActivity.class);
    }

    @OnClick(R.id.filtercontent)
    public void filterContent(View v){
        goToActivity(FilterContentActivity.class);
    }

    @OnClick(R.id.feedRedbone)
    public  void openDialog(View v){
        MusicDialog musicDialog = new MusicDialog(this);
        musicDialog.setCanceledOnTouchOutside(true);
        musicDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }


}
