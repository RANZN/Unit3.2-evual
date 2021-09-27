package com.ranzan.unit32evual.Network;

import com.ranzan.unit32evual.Api.ResponseClass;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("/search")
    Call<ResponseClass> getData(@Query("term") String term);
}
