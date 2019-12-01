package com.sabekur2017.randomprogrammingjokesrestexample.service;

import com.sabekur2017.randomprogrammingjokesrestexample.model.ProgrammingJokesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesApiService {
    @GET("/jokes/programming/ten")
    Call<List<ProgrammingJokesModel>> getAllProgrammingJokes();
}
