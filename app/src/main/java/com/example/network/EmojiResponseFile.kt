package com.example.network

import com.google.gson.annotations.SerializedName

data class EmojiResponseFile(
    @SerializedName("unicode") val unicode: ArrayList<String> = arrayListOf()
)
