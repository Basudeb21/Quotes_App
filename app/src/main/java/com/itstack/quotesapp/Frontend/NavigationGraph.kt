package com.itstack.quotesapp.Frontend

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(context: Context){

    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "all") {
        composable("splash") { SplashScreen(navController) }
        composable("options") { Options(navController) }
        composable("all") { AllQuotes(navController, context) }
    }
}