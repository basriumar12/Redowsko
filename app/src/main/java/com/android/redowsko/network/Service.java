package com.android.redowsko.network;

import com.android.redowsko.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Service {

    @FormUrlEncoded
    @POST("api/user/login")
    Call<ResponseLogin> postLogin(@Field("email") String username,
                                        @Field("password") String pass);
}
