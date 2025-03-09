package com.itstack.quotesapp.Backend

import android.content.Context
import com.itstack.quotesapp.ApiData.Quote
import com.itstack.quotesapp.ApiData.QuotsData
import com.itstack.quotesapp.RetrofitClient.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.itstack.quotesapp.RetrofitClient.RetrofitInstance

class QuotesHandler(val context: Context) {  // ✅ Ensure it's a class, not an interface
    fun fetchQuotes(onResult: (List<Quote>) -> Unit, onError: (String) -> Unit) { // ✅ Ensure function has a body
        val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)
        val call = apiService.getAllQuotes()

        call.enqueue(object : Callback<QuotsData> {
            override fun onResponse(call: Call<QuotsData>, response: Response<QuotsData>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.quotes?.let {
                        onResult(it)
                    } ?: onError("Data not found")
                } else {
                    onError("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<QuotsData>, t: Throwable) {
                onError("Error: ${t.message}")
            }
        })
    }

    fun randomQuote(onResult: (Quote) -> Unit, onError: (String) -> Unit) { // ✅ Ensure function has a body
        val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)
        val call = apiService.getRandomQuote()

        call.enqueue(object : Callback<Quote> {
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        onResult(it)
                    } ?: onError("Data not found")
                } else {
                    onError("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                onError("Error: ${t.message}")
            }
        })
    }
}

