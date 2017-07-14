package com.example.justin.finalprojectbeyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.activity_animation_tv)
    TextView textView;
    private Animation setAnimation;

    @OnClick(R.id.activity_main_ys_btn)
    public void profile (View view){
        goToActivity(FeedActivity.class);

    }
    @OnClick(R.id.activity_main_wn_btn)
    public void feed (View v){
        goToActivity(ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_set);
        textView.startAnimation(setAnimation);
    }
}
