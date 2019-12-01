package com.sabekur2017.randomprogrammingjokesrestexample.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiBuilder {
    public static final String BASE_URL = "https://official-joke-api.appspot.com";
    private Retrofit retrofit;

    public RestApiBuilder() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public JokesApiService getService() {
        return retrofit.create(JokesApiService.class);
    }
}
