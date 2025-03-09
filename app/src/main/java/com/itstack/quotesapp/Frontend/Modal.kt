package com.itstack.quotesapp.Frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itstack.quotesapp.ui.theme.Quotes_Text


//@Composable
//fun Modal(navController: NavController){
//    modal(navController)
//}


@Composable
//@Preview(showBackground = true)
fun modal(author: String, content: String, onClose: () -> Unit) {
    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(30.dp)
            .height(100.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.Yellow)
    ){
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = author,
                    fontSize = 18.sp,
                    color = Quotes_Text
                )

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { onClose() }

                )
            }
            Text(text = content,
                fontSize = 15.sp,
                color = Quotes_Text
            )
        }
    }

}
