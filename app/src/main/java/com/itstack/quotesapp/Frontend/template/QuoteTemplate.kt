package com.itstack.quotesapp.Frontend.template

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itstack.quotesapp.ui.theme.Card_BG1
import com.itstack.quotesapp.ui.theme.Quotes_Author_Text
import com.itstack.quotesapp.ui.theme.Quotes_Text

@Composable
@Preview(showBackground = true)
fun OneQuote(){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center

    ){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Card_BG1,
                contentColor = Color.Black
            )
        ) {
            Column (
                modifier = Modifier.padding(20.dp)
            ){
                Text(
                    text = "Abdul Kalam",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = Quotes_Author_Text
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Your heart is the size of an ocean. Go find yourself in its hidden depths.",
                    fontSize = 15.sp,
                    color = Quotes_Text

                )
            }

        }

    }
}