package com.example.emojiAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emojiViewHolder.EmojiViewHolder
import com.example.emojihub.R

class EmojiAdapter : RecyclerView.Adapter<EmojiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val emojiViewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.single_emoji, parent, false)
        return EmojiViewHolder(emojiViewHolder)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}