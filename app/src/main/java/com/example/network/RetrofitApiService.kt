package com.example.network

import retrofit2.http.GET

interface RetrofitApiService {
    @GET("all")
    fun getEmoji(): retrofit2.Call<EmojiResponseFile>
}