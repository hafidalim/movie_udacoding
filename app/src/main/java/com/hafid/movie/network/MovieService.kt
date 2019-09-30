package com.hafid.movie.network

import com.hafid.movie.login.data.ResultLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieService {

    @FormUrlEncoded
    @POST("loginUser")
    fun login(
        @Field("email") email : String,
        @Field("password") password : String

    ) : Call<ResultLogin>
}