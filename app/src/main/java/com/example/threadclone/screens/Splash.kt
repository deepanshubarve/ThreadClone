package com.example.threadclone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.threadclone.R
import com.example.threadclone.navigation.Routes
import kotlinx.coroutines.delay
import java.lang.reflect.Modifier

@Composable
fun Splash(navController: NavHostController){

   ConstraintLayout {
       val (image) = createRefs()
       Image(painter = painterResource(id = R.drawable.thread), contentDescription ="Thread",
           modifier = androidx.compose.ui.Modifier.constrainAs(image){
                 top.linkTo(parent.top)
               bottom.linkTo(parent.bottom)
               start.linkTo(parent.start)
               end.linkTo(parent.end)
       })
   }


    LaunchedEffect(true) {
        delay(3000)

        navController.navigate(Routes.BottomNav.routes)
    }
}