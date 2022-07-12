package com.example.emojiAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emojiDataSet.EmojiModel
import com.example.emojiViewHolder.EmojiViewHolder
import com.example.emojihub.R

class EmojiAdapter : RecyclerView.Adapter<EmojiViewHolder>() {

    private val emojiModels: ArrayList<EmojiModel> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val emojiViewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.single_emoji, parent, false)
        return EmojiViewHolder(emojiViewHolder)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        val emojiModel = emojiModels[position]
        holder.emojiTextView.text = emojiModel.unicodeCharacter
    }

    override fun getItemCount(): Int {
        return emojiModels.size
    }
}