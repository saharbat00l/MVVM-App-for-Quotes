package com.example.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val quoteText: Text
        get() = findViewById(R.id.quoteText)
    //want to call composable
    private val authorText: Text
        get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel= ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())
    }



    fun setQuote(quote: Quote){
        quoteText.textContent = quote.text
        authorText.textContent = quote.author }

    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }
    fun onPrevious(view: View) {
        setQuote(mainViewModel.previousQuote())
    }
}