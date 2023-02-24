package com.swetha.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {

    @GET("posts")
    Call<List<Datum>> getPosts();

    @POST("posts")
    Call<PostReq> postData(@Body PostReq postReq);
}
