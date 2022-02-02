package com.rakushkins.madmeditationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView login_register = (TextView) findViewById(R.id.login_register);
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegister;
                toRegister = new Intent(Login.this, Register.class);
                startActivity(toRegister);
            }
        });

        Button login_sign_in_btn = (Button) findViewById(R.id.login_sign_in_btn);
        login_sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText login_form_email = (EditText) findViewById(R.id.login_form_email);
                EditText login_form_password = (EditText) findViewById(R.id.login_form_password);
                if (login_form_email.getText().toString().trim().equals("")) {
                    Toast.makeText(Login.this, R.string.no_email_filled, Toast.LENGTH_LONG).show();
                }
                else if (login_form_password.getText().toString().trim().equals("")) {
                    Toast.makeText(Login.this, R.string.no_password_filled, Toast.LENGTH_LONG).show();
                }
                else if (!login_form_email.getText().toString().trim().contains("@")) {
                    Toast.makeText(Login.this, R.string.no_at, Toast.LENGTH_LONG).show();
                }
                else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                            .addConverterFactory(JacksonConverterFactory.create())
                            .build();

                    MadApi madApi = retrofit.create(MadApi.class);

                    LoginBody loginBody = new LoginBody();
                    loginBody.setEmail(login_form_email.getText().toString().trim());
                    loginBody.setPassword(login_form_password.getText().toString());

                    Call<LoginResponse> login = (Call<LoginResponse>) madApi.loginUser(loginBody);
                    login.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                String nickname = response.body().getNickName();
                                String avatar = response.body().getAvatar();

                                Intent toMain, toProfile;
                                toMain = new Intent(Login.this, Main.class);
                                toProfile = new Intent(Login.this, Profile.class);

                                toMain.putExtra("nickname", nickname);
                                toMain.putExtra("avatar", avatar);

                                toProfile.putExtra("nickname", nickname);
                                toProfile.putExtra("avatar", avatar);

                                startActivity(toMain);

                            } else {
                                Toast.makeText(Login.this, R.string.response_unsuccess + response.code(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(Login.this, R.string.no_response + t.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        Button login_profile_btn = (Button) findViewById(R.id.login_profile_btn);
        login_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}