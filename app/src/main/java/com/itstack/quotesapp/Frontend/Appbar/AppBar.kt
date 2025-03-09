package com.itstack.quotesapp.Frontend.Appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.itstack.quotesapp.ui.theme.Top_Bar
import com.itstack.quotesapp.ui.theme.ICON_COLOR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun topAppBar(){
    TopAppBar(
        title = {Text(text = "Quote")},
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Share, contentDescription = "")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = "")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.MoreVert, contentDescription = "")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Top_Bar,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black,
            actionIconContentColor = Color.Black
        )

    )
}

@Composable
@Preview(showBackground = true)
fun bottomAppBar(){
    BottomAppBar(
        actions = {
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth())
            {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Person, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Home, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Edit, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Settings, contentDescription = "")
                }
            }
        },
        containerColor = Top_Bar,
        contentColor = ICON_COLOR
    )

}