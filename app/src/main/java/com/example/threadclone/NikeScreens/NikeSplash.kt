package com.example.threadclone.NikeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.threadclone.R

@Composable
fun NikeSplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.nikesplash),
            contentDescription = "Nike Swoosh",
            modifier = Modifier
                .align(Alignment.Center)
                .width(120.dp)
                .height(40.dp)
        )
    }
}

@Preview
@Composable
fun preview(){
    NikeSplashScreen()
}