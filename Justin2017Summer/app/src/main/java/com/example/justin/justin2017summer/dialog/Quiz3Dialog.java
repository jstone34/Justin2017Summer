package com.example.justin.justin2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.justin.justin2017summer.MainActivity;
import com.example.justin.justin2017summer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Justin on 6/21/2017.
 */


public class Quiz3Dialog extends Dialog {
    @BindView(R.id.dialog_quiz3_radiogroup)
    RadioGroup radioGroup;
    private String checkedID;

    @OnClick(R.id.dialog_quiz3_Cancel)
    public void ok(View v){
        cancel();
    }

    @OnClick(R.id.dialog_quiz3_ok)
    public void close(View v){
     System.exit(0);
    }

    public Quiz3Dialog(@NonNull Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_quiz3);
        ButterKnife.bind(this);

    }
}
