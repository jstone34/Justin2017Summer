package com.example.justin.justin2017summer.controller;

import android.content.Context;
import android.content.Intent;

import com.example.justin.justin2017summer.service.TestService;

/**
 * Created by Justin on 7/5/2017.
 */

public class TestAudioController {

    public final static int AUDIOPLAYING = 111;
    public final static int AUDIOLOADING = 222;
    public final static int AUDIOPAUSED = 333;
    private static  Context context;

    public int STATUS = 0;

    public  TestAudioController(Context context){
        this.context = context;
    }

    public static void play(String URL){
        Intent intent = new Intent(context, TestService.class);
    }
}
