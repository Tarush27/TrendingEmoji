package com.example.emojiViewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emojihub.R

class EmojiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val emojiTextView: TextView = itemView.findViewById(R.id.emoji_text_view)
}