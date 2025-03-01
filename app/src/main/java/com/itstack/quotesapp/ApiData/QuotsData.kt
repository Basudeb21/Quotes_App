package com.itstack.quotesapp.ApiData

data class QuotsData(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)