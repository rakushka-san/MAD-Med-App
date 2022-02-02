package com.rakushkins.madmeditationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Onboarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        Button onb_login_btn = (Button) findViewById(R.id.onb_login_btn);
        onb_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin;
                toLogin = new Intent(Onboarding.this, Login.class);
                startActivity(toLogin);
            }
        });

        TextView onb_register = (TextView) findViewById(R.id.onb_register);
        onb_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegister;
                toRegister = new Intent(Onboarding.this, Register.class);
                startActivity(toRegister);
            }
        });
    }
}