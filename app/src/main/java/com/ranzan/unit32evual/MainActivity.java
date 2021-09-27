package com.ranzan.unit32evual;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.unit32evual.Adapter.Adapter;
import com.ranzan.unit32evual.Api.ResponseClass;
import com.ranzan.unit32evual.Api.ResultsItem;
import com.ranzan.unit32evual.Listner.ItemClickListener;
import com.ranzan.unit32evual.Network.ApiClient;
import com.ranzan.unit32evual.Network.Network;
import com.ranzan.unit32evual.Service.MusicService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private EditText editText;
    private Button btn;
    private Adapter adapter;
    private List<ResultsItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }


    private void setRecyclerView() {
        adapter = new Adapter(list, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.search);
        btn = findViewById(R.id.btnSearch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiClient apiClient = Network.getRetrofitInstance().create(ApiClient.class);
        apiClient.getData(editText.getText().toString()).enqueue(new Callback<ResponseClass>() {
            @Override
            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                if (response.body() != null) {
                    list = response.body().getResults();
                    adapter.updateDataList(list);
                }
            }

            @Override
            public void onFailure(Call<ResponseClass> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPlay(ResultsItem resultsItem, int position) {
        Intent intent = new Intent(MainActivity.this, MusicService.class);
       intent.putExtra("data", (Serializable) resultsItem);
        startService(intent);
    }

    @Override
    public void onPause(ResultsItem resultsItem, int position) {

    }

    @Override
    public void onDelete(ResultsItem resultsItem, int position) {
        list.remove(position);
        adapter.updateDataList(list);
    }
}