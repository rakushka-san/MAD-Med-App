package com.rakushkins.madmeditationapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Bundle args = getIntent().getExtras();

        TextView main_hello = (TextView) findViewById(R.id.main_hello);
        main_hello.setText("С возвращением, " + args.get("nickname") + "!");

        LinearLayout ll_feelings = (LinearLayout) findViewById(R.id.ll_feelings);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        MadApi madApi = retrofit.create(MadApi.class);
        Call<List<Feelings>> feelings = (Call<List<Feelings>>) madApi.feelings();
        feelings.enqueue(new Callback<List<Feelings>>() {
            @Override
            public void onResponse(Call<List<Feelings>> call, Response<List<Feelings>> response) {

//                for (int i = 0; i < response.body().size(); i++) {
//
//                }
                ArrayList<TextView> feelings = new ArrayList<TextView>();

                for (int i = 0; i < response.body().size(); i++) {
                    feelings.add(new TextView(Main.this));
                    feelings.get(i).setText(response.body().get(i).getData().getTitle());
                    ll_feelings.addView(feelings.get(i));
                }

            }

            @Override
            public void onFailure(Call<List<Feelings>> call, Throwable t) {

            }
        });

    }
}