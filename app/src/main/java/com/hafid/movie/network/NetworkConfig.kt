package com.hafid.movie.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig{
    fun getInterceptor() : OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("192.168.10.193/server_movie/Api/")

                //fun getinterceptor
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun service(){
        getRetrofit().create(MovieService::class.java)
    }
}