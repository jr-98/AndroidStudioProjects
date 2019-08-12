package com.example.jonathan.jonathantillaguangoex5.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jonathan.jonathantillaguangoex5.R;

public class SplashScrean extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screan);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScrean.this,MainActivity.class);
                startActivity(intent);
            }
        },2000);
    }
}
