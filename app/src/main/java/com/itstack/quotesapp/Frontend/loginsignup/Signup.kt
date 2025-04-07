package com.itstack.quotesapp.Frontend.loginsignup


import android.content.Context
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
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import com.itstack.quotesapp.Backend.FireBaseConn.Signup

@Composable
fun SignupPage(navController: NavController, context: Context){
    signupPage(context, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun signupPage(context: Context, navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cpassword by remember { mutableStateOf("") }
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
                Text(text = "Signup",
                    color = LOGIN_BG,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 45.sp)
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LOGIN_BG,
                        unfocusedBorderColor = Color.Gray
                    )
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                OutlinedTextField(
                    value = cpassword,
                    onValueChange = { cpassword = it },
                    label = { Text("Confirm Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    modifier = Modifier.padding(horizontal = 55.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = LOGIN_BG),
                    onClick = {
                        if (email.isEmpty()){
                            Toast.makeText(context, "Enter your email", Toast.LENGTH_SHORT).show()
                        }
                        else if (password.isEmpty()){
                            Toast.makeText(context, "Enter your password", Toast.LENGTH_SHORT).show()
                        }
                        else if (cpassword.isEmpty()){
                            Toast.makeText(context, "Enter your confirm password", Toast.LENGTH_SHORT).show()
                        }
                        else if (!password.equals(cpassword)){
                            Toast.makeText(context, "Password and Confirm password must be same", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            val sup = Signup(context)
                            sup.signupUser(email, password, context, navController)
                        }
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Signup", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "already have an account? login",
                    color = Color.Blue,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = 15.sp,
                    modifier = Modifier.clickable(onClick = {navController.navigate("login")})
                )

            }
        }
    }
}