package com.rakushkins.madmeditationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Intent toOnb;
        toOnb = new Intent(SplashScreen.this, Onboarding.class);
        startActivity(toOnb);
    }
}