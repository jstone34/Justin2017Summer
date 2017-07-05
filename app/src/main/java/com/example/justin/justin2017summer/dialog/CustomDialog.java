package com.example.justin.justin2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.justin.justin2017summer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Justin on 6/21/2017.
 */

public class CustomDialog extends Dialog {

    public interface iCustomDialogListener{
        public void onOKClicked(String msg);
    }

    @OnClick(R.id.dialog_custom_ok)
    public void ok (View view){
        cancel();
    }
    public CustomDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
    }
}
