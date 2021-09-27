package com.ranzan.unit32evual.Network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("/search")
    Call<Response> getData(@Query("term") String term);
}
