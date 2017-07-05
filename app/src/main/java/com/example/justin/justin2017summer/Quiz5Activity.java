package com.example.justin.justin2017summer;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.justin.justin2017summer.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz5Activity extends BaseActivity implements View.OnTouchListener {

    private GestureDetector gestureDetector;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;


    @BindView(R.id.activity_quiz5_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this, new Quiz5Activity.simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();


                if (x1<x2) {
                   //left to right
                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", x1, x2+320);
                    animator.start();
                    shortToast("Swipe from right to left");

                }
                if(x1>x2) {

                    //left to right
                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", x1, x2);
                    animator.start();
                    shortToast("Swipe from left to right");
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
     @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

         ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", 0, distanceX);
         animator.start();
            UtilLog.d("Gesture", "OnScroll");
            UtilLog.d("Gesture", "distanceX " + distanceX);
            UtilLog.d("Gesture", "distanceY " + distanceY);
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }
}
