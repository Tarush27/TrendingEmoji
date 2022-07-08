package com.example.emojihub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emojiAdapter.EmojiAdapter

class EmojiActivity : AppCompatActivity() {
    private val emojiRecyclerView: RecyclerView
        get() = findViewById(R.id.emoji_rv)
    private lateinit var emojiAdapter: EmojiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emoji_activity)
        setupEmojiRecyclerView()
    }

    private fun setupEmojiRecyclerView() {
        emojiRecyclerView.layoutManager = LinearLayoutManager(this@EmojiActivity)
        emojiAdapter = EmojiAdapter()
        emojiRecyclerView.adapter = emojiAdapter
    }
}