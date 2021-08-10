package com.example.example_mvvm.domain

import com.example.example_mvvm.data.QuoteRepository
import com.example.example_mvvm.data.model.QuoteModel
import com.example.example_mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
//    private val repository = QuoteRepository()

    //    según el video, lo correcto sería volver a recuperar los datos del repositorio
    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}