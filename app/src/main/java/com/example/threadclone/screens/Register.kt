package com.example.threadclone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.example.threadclone.navigation.Routes
import java.lang.reflect.Modifier


@Composable
fun Register(navHostController: NavHostController){

 var email by remember {
     mutableStateOf(" ")
 }

    var password by remember {
        mutableStateOf(" ")
    }
    var name by remember {
        mutableStateOf(" ")
    }
    var username by remember {
        mutableStateOf(" ")
    }
    var bio by remember {
        mutableStateOf(" ")
    }

    Column(modifier = androidx.compose.ui.Modifier
        .fillMaxSize()
        .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center) {

        Text(text = "Welcome to Thread!", style = TextStyle(fontFamily = FontFamily.Serif, fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp))

        Box(modifier = androidx.compose.ui.Modifier.height(30.dp))

        Text(text = "Register here", style = TextStyle(fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp))

        Box(modifier = androidx.compose.ui.Modifier.height(30.dp))

        OutlinedTextField(value = name, onValueChange = {name = it}, label = {
            Text(text = "Name")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ), singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth())

        OutlinedTextField(value = username, onValueChange = {username = it}, label = {
            Text(text = "Username")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ), singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth())

        OutlinedTextField(value = bio, onValueChange = {bio = it}, label = {
            Text(text = "Bio")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ), singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth())

        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "Email")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ), singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth())



        OutlinedTextField(value = password, onValueChange = {password = it}, label = {
            Text(text = "Password")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ), singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth())

        Box(modifier = androidx.compose.ui.Modifier.height(50.dp))

        ElevatedButton(onClick = { /*TODO*/ }, modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
            Text(text = "Register here", style = TextStyle(fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp), modifier = androidx.compose.ui.Modifier.padding(vertical = 8.dp))


        }
        TextButton(onClick = {

            navHostController.navigate(Routes.Login.routes){
                                 popUpTo(navHostController.graph.startDestinationId)
                                 launchSingleTop =true
                             }
        }, modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
            Text(text = "Already register? login here", style = TextStyle(fontWeight = FontWeight.Bold,
                fontSize = 15.sp))


        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegisterView (){
    //Register()
}