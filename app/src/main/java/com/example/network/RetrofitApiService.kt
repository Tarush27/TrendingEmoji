package com.example.network

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiService {
    @GET("/random")
    fun getEmoji(): Call<EmojiResponseFile>
}