package com.sabekur2017.randomprogrammingjokesrestexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sabekur2017.randomprogrammingjokesrestexample.adapter.RecylerAdapterProgrammingAdaper;
import com.sabekur2017.randomprogrammingjokesrestexample.model.ProgrammingJokesModel;
import com.sabekur2017.randomprogrammingjokesrestexample.service.JokesApiService;
import com.sabekur2017.randomprogrammingjokesrestexample.service.RestApiBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecylerAdapterProgrammingAdaper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        JokesApiService jokesApiService = new RestApiBuilder().getService();
        Call<List<ProgrammingJokesModel>> listCall = jokesApiService.getAllProgrammingJokes();
        listCall.enqueue(new Callback<List<ProgrammingJokesModel>>() {
            @Override
            public void onResponse(Call<List<ProgrammingJokesModel>> call, Response<List<ProgrammingJokesModel>> response) {
                if (response.isSuccessful()) {
                    fetchDataInList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ProgrammingJokesModel>> call, Throwable t) {

            }
        });
    }

    private void fetchDataInList(List<ProgrammingJokesModel> joketList) {

        adapter = new RecylerAdapterProgrammingAdaper(this, joketList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
