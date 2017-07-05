package com.example.justin.justin2017summer;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.justin.justin2017summer.dialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {

    private final int DIALOG = 12345;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast("Dialog Message is: " +s);
                    break;
                default:
            }
        }
    };

    @BindView(R.id.activity_dialog)
    RadioGroup radioGroup;
    private int checkedID;
  ;

    @OnClick(R.id.activity_dialog_OK)
    public void ok(View view){
        switch (checkedID) {
            case R.id.activity_dialog_normal:
                normalDialog();
                break;
            case R.id.activity_dialog_list:
                listDialog();
                break;
            case R.id.activity_dialog_singleChoice:
                singleChoiceDialog();
                break;
            case R.id.activity_dialog_multiChoise:
                multiChoiceDialog();
                break;
            case R.id.activity_dialog_waiting:
                setWaitingDialog();
                break;
            case R.id.activity_dialog_progress:
                progressDialog();
                break;
            case R.id.activity_dialog_input:
                inputDialog();
                break;
            case R.id.activity_dialog_custom:
                CustomDialog customDialog = new CustomDialog(this);
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

            }
        }));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;

            }
        });
    }

    public void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Alert Title");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Neutral");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Cancel");
            }
        });
        builder.show();

    }

    ProgressDialog waitingDialog;
    private void setWaitingDialog() {
        waitingDialog =new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.setCanceledOnTouchOutside(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                shortToast("Dialog was canceled!");
            }
        });
    }

    ArrayList<Integer> choices = new ArrayList<>();
    private void multiChoiceDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"  };
        final boolean initChoiceSets[]={false,true,false,false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a multi-choice Dialog");
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    choices.add(which);
                } else{
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str = "";
                for (int i =0; i< size; i++){
                    str += items[choices.get(i)] + "";
                }
                shortToast("You chose: " +str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                shortToast("Cancel was clicked");
            }
        });
        builder.show();
    }

    int choice = 2;
    private void singleChoiceDialog(){
        final String[] items = {"item1", "item2", "item3", "item4"  };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("I'm a Single Choice Dialog");
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: " +choice);
            }
        });
        builder.show();
    }

    public void listDialog(){
        final String[] items = {"item","item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a list Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: "+items[which]);
            }
        });
       builder.show();
    }

    private void progressDialog(){
        final int MAX_PROGRESS =100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress =0;
                while (progress< MAX_PROGRESS){
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                Bundle bundle = new Bundle();
                bundle.putString("msg", "Download Success");
                Message msg = Message.obtain();
                msg.what = DIALOG;
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                progressDialog.cancel();
            }
        }).start();
    }

    private void inputDialog(){
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
        inputDialog.setTitle("I'm an input Dialog").setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("cancel", null).show();
    }
}
