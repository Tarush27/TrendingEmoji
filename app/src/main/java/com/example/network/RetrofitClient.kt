package com.example.network

import com.example.constants.EMOJI_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(EMOJI_URL)
        .build()
    private val retrofitService = retrofit.create(RetrofitApiService::class.java)
    val retrofitApiService: RetrofitApiService get() = retrofitService
}