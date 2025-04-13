package com.itstack.quotesapp.Frontend.template

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
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
import androidx.compose.material3.Icon
import androidx.compose.ui.platform.LocalContext
import com.itstack.quotesapp.Backend.FireBaseConn.AddDataToFireBase
import android.widget.Toast

@Composable
fun OneQuote(author: String, content: String, id : String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Card_BG1,
                contentColor = Color.Black
            )
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically // Aligns items properly
                ) {
                    Text(
                        text = author,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = Quotes_Author_Text,
                        modifier = Modifier.weight(1f) // Pushes the icon to the right
                    )
                    Row {
                        IconButton(
                            onClick = { /* Copy logic */ },
                            modifier = Modifier.size(27.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ContentCopy,
                                contentDescription = "Copy",
                                tint = Color.Black,
                                modifier = Modifier.padding(5.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                val add = AddDataToFireBase(context)
                                add.addtofevorite(id, content, author){result ->
                                    if (result){
                                        Toast.makeText(context, "Data successfully added....",
                                            Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(context, "Data not added....",
                                            Toast.LENGTH_SHORT).show()
                                    }

                                }
                                    },
                            modifier = Modifier.size(27.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "FEV",
                                tint = Color.Black,
                                modifier = Modifier.padding(5.dp)


                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = content,
                    fontSize = 15.sp,
                    color = Quotes_Text
                )
            }
        }
    }
}
