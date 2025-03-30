package com.itstack.quotesapp.Frontend.loginsignup

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itstack.quotesapp.R
import com.itstack.quotesapp.ui.theme.LOGIN_BG

@Composable
fun LoginPage(navController: NavController){
    loginPage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun loginPage(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Row(modifier = Modifier.background(LOGIN_BG)) {
            Row(modifier = Modifier.fillMaxWidth()
                .padding(50.dp),
                horizontalArrangement = Arrangement.Center){
                Image(painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo")
            }
        }

        Row (modifier = Modifier.padding(top = 50.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            Column (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "LOGIN",
                    color = LOGIN_BG,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 45.sp)
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedTextColor = LOGIN_BG,
                        unfocusedTextColor = LOGIN_BG,
                        focusedBorderColor = LOGIN_BG,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = LOGIN_BG,
                        focusedLabelColor = LOGIN_BG,
                        unfocusedLabelColor = LOGIN_BG
                    )
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedTextColor = LOGIN_BG,
                        unfocusedTextColor = LOGIN_BG,
                        focusedBorderColor = LOGIN_BG,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = LOGIN_BG,
                        focusedLabelColor = LOGIN_BG,
                        unfocusedLabelColor = LOGIN_BG
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    modifier = Modifier.padding(horizontal = 55.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = LOGIN_BG),
                    onClick = {},
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Login", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "don't have an account? signup",
                    color = Color.Blue,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = 15.sp)

            }
        }
    }
}