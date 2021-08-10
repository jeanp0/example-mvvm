package com.example.example_mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.example_mvvm.databinding.ActivityMainBinding
import com.example.example_mvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //    viewModels() se encarga de toda la conexión del viewModel al activity
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, { currentQuote ->
            binding.textQuote.text = currentQuote.quote
            binding.textAuthor.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(this, { isLoading ->
            binding.progressApp.isVisible = isLoading
        })

        binding.layoutContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}