package com.example.example_mvvm.data.network

import com.example.example_mvvm.core.RetrofitHelper
import com.example.example_mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
//        corrutinas
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient:: class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}