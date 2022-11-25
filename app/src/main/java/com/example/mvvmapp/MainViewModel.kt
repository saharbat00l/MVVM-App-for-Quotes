package com.example.mvvmapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context:Context): ViewModel() {

    //variables to track the quotelist
    private var quoteList : Array<Quote> = emptyArray()
    private var index = 0
    //initializing
    init {
        quoteList = loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        //json conversion to string
        val json = String(buffer, Charsets.UTF_8)
        //implementing json library,
        val gson = Gson()
     return   gson.fromJson(json, Array<Quote>:: class.java) }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index]
    fun previousQuote() = quoteList[--index]
}