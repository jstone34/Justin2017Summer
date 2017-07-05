package com.example.justin.justin2017summer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferenceActivity extends BaseActivity {

    @BindView(R.id.activity_shared_preference_email)
    EditText emailEditText;

    @BindView(R.id.activity_shared_preference_password)
    EditText passwordEditText;

    private final String EMAIL = "email";
    private final String PASSWORD = "password";
    private final String USER = "user";

    @OnClick(R.id.activity_shared_preference_clean)
    public void clear(View v){
        SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        emailEditText.setText("");
        passwordEditText.setText("");
        shortToast("Cleaned");
    }

    @OnClick(R.id.activity_shared_preference_login)
    public void loing(View v){
        String Email = emailEditText.getText().toString();
        String Password = passwordEditText.getText().toString();
        check(Email, Password);

        if(check(Email,Password)){
            shortToast("Login Success");
        }
    }

    private boolean check(String email, String password){
        boolean passwordCorrect = true;
        if(passwordCorrect){
            SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(EMAIL, email);
            editor.putString(PASSWORD, password);
            editor.commit();
            passwordCorrect = true;
        }
        else{
            passwordCorrect =false;
        }
        return passwordCorrect;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);
        retriveLoginInfo();
    }

    private void retriveLoginInfo() {
        SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE);
       String email = sp.getString(EMAIL, "null");
        String password = sp.getString(PASSWORD, "null");
        if(!email.equals("null")){
            emailEditText.setText(email);
            passwordEditText.setText(password);
        }
    }
}
