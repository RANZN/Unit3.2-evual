package com.ranzan.unit32evual;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.unit32evual.Adapter.RecyclerViewAdapter;
import com.ranzan.unit32evual.Api.ResultsItem;
import com.ranzan.unit32evual.Network.ApiClient;
import com.ranzan.unit32evual.Network.Network;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView searchView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<ResultsItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiClient apiClient = Network.getRetrofitInstance().create(ApiClient.class);
        apiClient.getData(searchView.getQuery().toString()).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if (response.body() != null) {
                    Log.d("abc", response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}