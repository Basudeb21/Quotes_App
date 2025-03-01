package com.itstack.quotesapp.Frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
//@Preview(showBackground = true)
fun Options(navController: NavController){
    options(navController)
}

@Composable
//@Preview(showBackground = true)
fun options(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Options")

            Button(
                onClick = {
                    navController.navigate("modal")
                }
            ) {
                Text(text = "Next Page")
            }
        }
    }
}