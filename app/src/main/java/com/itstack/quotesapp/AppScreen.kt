package com.itstack.quotesapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.itstack.quotesapp.Frontend.AppNavigation
import com.itstack.quotesapp.Frontend.Appbar.bottomAppBar
import com.itstack.quotesapp.Frontend.Appbar.topAppBar
import com.itstack.quotesapp.Frontend.NavigationGraph
import com.itstack.quotesapp.ui.theme.QuotesAppTheme

class AppScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                topBar = { topAppBar() },
                bottomBar = { bottomAppBar(LocalContext.current) }
            ) { innerPadding ->
                AppNavigation(LocalContext.current)
            }
        }
    }
}