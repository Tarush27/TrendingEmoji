package com.example.network

import com.google.gson.annotations.SerializedName

class EmojiResponseFile: ArrayList<Emoji>( )

data class Emoji(
    @SerializedName("unicode") val unicodes: List<String> = arrayListOf()
) {
}