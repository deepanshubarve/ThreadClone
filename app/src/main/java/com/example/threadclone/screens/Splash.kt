package com.example.threadclone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.threadclone.R
import com.example.threadclone.navigation.Routes
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.getInstance
import com.google.firebase.auth.auth
import com.google.firebase.database.core.Context
import com.google.firebase.initialize
import kotlinx.coroutines.delay


@Composable
fun Splash(navController: NavHostController) {

    ConstraintLayout {

        val (image) = createRefs()
        Image(painter = painterResource(id = R.drawable.thread), contentDescription = "Thread",
            modifier = androidx.compose.ui.Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.size(48.dp)
        )
    }


    LaunchedEffect(true) {
        delay(3000)

            if (getInstance().currentUser != null) {
           navController.navigate(Routes.BottomNav.routes){
               popUpTo(navController.graph.startDestinationId)
               launchSingleTop = true
           }
            } else
            navController.navigate(Routes.Login.routes){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
    }

}

