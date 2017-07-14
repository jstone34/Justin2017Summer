package com.example.justin.justin2017summer;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Type;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.animation;

public class AnimatorActivity extends BaseActivity {

    private ValueAnimator repeatAnimator;

    @BindView(R.id.animator_tv)
    TextView tv;

    @OnClick(R.id.animator_btn_start)
    public void startAnimator(){
        repeatAnimator = doAnimatorListener();
        repeatAnimator.start();
    }

    @OnClick(R.id.animator_btn_stop)
    public void cancelAnimator(){
        repeatAnimator.cancel();
        repeatAnimator.removeAllListeners();
    }

    @OnClick(R.id.animator_trans)
    public void trans(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationY", 0, -120);
        animator.setDuration(2000);
        animator.start();
    }

    @OnClick(R.id.animator_scale)
    public void scale(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "scaleY", 0, 3,1);
        animator.setDuration(2000);
        animator.start();;
    }

    @OnClick(R.id.animator_color)
    public void color(){
        ObjectAnimator animator = ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 3,1);
        animator.setDuration(8000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }

    @OnClick(R.id.animator_alpha)
    public void alpha(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "alpha", 1,0,1);
        animator.setDuration(2000);
        animator.start();;
    }

    @OnClick(R.id.animator_rotation)
    public void rotation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "rotationY",0,360,0);
        animator.setDuration(4000);
        animator.start();;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);
    }

    private ValueAnimator doAnimatorListener(){
        ValueAnimator animator = ValueAnimator.ofInt(0,700);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                shortToast("Started");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                shortToast("Ended");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                shortToast("Canceled");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                shortToast("Repeated");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(2);
        animator.setDuration(2000);
        return animator;
    }

  /* public class ArgbEvaluator implements TypeEvaluator{
        public Object evaluate(float fraction, Object startValue, Object endValue){
            int startInt = (Integer)startValue;
            int startA = (startInt >> 24);
            int startR = (startInt >> 16) & 0xff;
            int startG = (startInt >> 8) & 0xff;
            int startB = startInt & 0xff;
            int endInt = (Integer) endValue;
            int endA = (endInt >> 24);
            int endR = endInt >> 16) & 0xff;
            return (int)((startA)+ (int) (fraction * (endA - startA)));
        }
    }*/

}
