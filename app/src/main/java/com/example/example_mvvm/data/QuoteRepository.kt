package com.example.example_mvvm.data

import com.example.example_mvvm.data.model.QuoteModel
import com.example.example_mvvm.data.model.QuoteProvider
import com.example.example_mvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
//        guarda en memoria las quotes
        QuoteProvider.quotes = response
        return response
    }
}