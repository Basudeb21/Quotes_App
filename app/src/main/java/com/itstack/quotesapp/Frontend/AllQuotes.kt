package com.itstack.quotesapp.Frontend

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itstack.quotesapp.ApiData.Quote
import com.itstack.quotesapp.Backend.QuotesHandler
import com.itstack.quotesapp.Frontend.template.OneQuote

@Composable
fun AllQuotes(navController: NavController, context: Context) {
    allQuotes(navController, context)
}

@Composable
fun allQuotes(navController: NavController, context: Context) {

    var quotesList by remember { mutableStateOf<List<Quote>>(emptyList()) }
    var error_msg by remember { mutableStateOf<String>("") }
    var loading by remember { mutableStateOf(true) }

    var randomQuote by remember { mutableStateOf<Quote?>(null) }
    var showModal by remember { mutableStateOf(true) }  //

    LaunchedEffect(Unit) {
        val handler = QuotesHandler(context)

        handler.fetchQuotes(
            onResult = {
                quotesList = it
                loading = false
            },
            onError = {
                error_msg = it
                loading = false
            }
        )

        handler.randomQuote(
            onResult = {
                randomQuote = it
            },
            onError = {
                error_msg = it
            }
        )


    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showModal && randomQuote != null) {
            modal(
                author = randomQuote!!.author,
                content = randomQuote!!.quote,
                onClose = { showModal = false } // Close modal on click
            )
        }


        when {
            loading -> {
                CircularProgressIndicator()
            }
            error_msg.isNotEmpty() -> {
                Text(text = error_msg)
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.padding(vertical = 5.dp)
                ) {
                    items(quotesList) { quote ->
                        OneQuote(author = quote.author, content = quote.quote)
                    }
                }
            }
        }
    }
}
