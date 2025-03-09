package com.itstack.quotesapp.RetrofitClient

import com.itstack.quotesapp.ApiData.Quote
import com.itstack.quotesapp.ApiData.QuotsData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("quotes")
    fun getAllQuotes(): Call<QuotsData>
    @GET("quote/random")
    fun getRandomQuote(): Call<Quote>
}