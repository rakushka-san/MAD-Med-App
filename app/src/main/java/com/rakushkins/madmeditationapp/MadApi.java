package com.rakushkins.madmeditationapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MadApi {
    @GET("quotes")
    Call<List<Quotes>> qoutes();

    @GET("feelings")
    Call<List<Feelings>> feelings();

    @POST("user/login")
    LoginResponse loginUser(@Body LoginBody loginBody);
}
