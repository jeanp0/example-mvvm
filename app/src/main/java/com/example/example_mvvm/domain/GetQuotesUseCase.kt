package com.example.example_mvvm.domain

import com.example.example_mvvm.data.QuoteRepository
import com.example.example_mvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}