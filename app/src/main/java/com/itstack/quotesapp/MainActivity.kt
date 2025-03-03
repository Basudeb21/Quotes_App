package com.itstack.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.itstack.quotesapp.Frontend.Appbar.bottomAppBar
import com.itstack.quotesapp.Frontend.Appbar.topAppBar
import com.itstack.quotesapp.Frontend.NavigationGraph
import com.itstack.quotesapp.ui.theme.QuotesAppTheme
import com.itstack.quotesapp.ui.theme.BG_ALL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                topBar = { topAppBar() },
                bottomBar = { bottomAppBar() }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavigationGraph(LocalContext.current)
                }
            }
        }

    }
}
