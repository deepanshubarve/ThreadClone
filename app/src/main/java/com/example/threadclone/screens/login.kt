package com.example.threadclone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph
import java.lang.reflect.Modifier


@Composable
fun login(){

 var email by remember {
     mutableStateOf(" ")
 }
    Column(modifier = androidx.compose.ui.Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center) {

        Text(text = "Login", style = TextStyle(fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp))

        Box(modifier = androidx.compose.ui.Modifier.height(30.dp))

        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "Email")
        })
    }
}
@Preview(showBackground = true)
@Composable
fun LoginView (){
    login()
}