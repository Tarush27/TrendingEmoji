package com.example.emojihub

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.emojiAdapter.EmojiAdapter
import com.example.emojiDataSet.EmojiModel
import com.example.network.Emoji
import com.example.network.EmojiResponseFile
import com.example.network.RetrofitApiService
import com.example.network.RetrofitClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmojiActivity : AppCompatActivity() {
    private val emojiRecyclerView: RecyclerView
        get() = findViewById(R.id.emoji_rv)
    private lateinit var emojiAdapter: EmojiAdapter
    private val swipeRefreshLayout: SwipeRefreshLayout
        get() = findViewById(R.id.swipeRefreshLayout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emoji_activity)
        setupEmojiRecyclerView()
        fetchEmoji()
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            fetchEmoji()
        }
    }

    private fun createSnackBar() {
        Snackbar.make(swipeRefreshLayout, "No connection", Snackbar.LENGTH_SHORT).show()
    }

    private fun setupEmojiRecyclerView() {
        emojiRecyclerView.layoutManager = LinearLayoutManager(this@EmojiActivity)
        emojiAdapter = EmojiAdapter()
        emojiRecyclerView.adapter = emojiAdapter
    }

    private fun emojiModel(it: String) = EmojiModel(
        unicodeCharacter = getEmojiByUnicode(
            Integer.parseInt(it.substring(2), 16)
        )
    )

    private fun getEmojiByUnicode(unicode: Int): String {
        return String(Character.toChars(unicode))
    }

    private fun fetchEmoji() {
        val service: RetrofitApiService = RetrofitClient.retrofitApiService
        val retrieveEmoji: Call<EmojiResponseFile> = service.getEmoji()
        retrieveEmoji.enqueue(object : Callback<EmojiResponseFile> {
            override fun onResponse(
                call: Call<EmojiResponseFile>,
                response: Response<EmojiResponseFile>
            ) {

                swipeRefreshLayout.isRefreshing = false
                Log.d("response", response.body().toString())
                if (response.isSuccessful) {
                    val responseFile = response.body()
                    for (i in responseFile!!) {
                        val emojis = i.unicodes.map {
                            emojiModel(it)
                        }
                        Log.d("chars", "chars: $emojis")
                        emojiAdapter.displayEmoji(emojis)
                    }
                } else {
                    createSnackBar()
                }


            }

            override fun onFailure(call: Call<EmojiResponseFile>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                createSnackBar()
            }

        })
    }
}