package com.nehar5383.itunes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
@FormUrlEncoded
    @POST("https://itunes.apple.com/search")
    Call<ResObj> Search(@Field("term") String username);
}
