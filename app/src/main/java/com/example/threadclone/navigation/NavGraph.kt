package com.example.threadclone.navigation

import android.app.Notification
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.threadclone.screens.AddThreads
import com.example.threadclone.screens.BottomNav
import com.example.threadclone.screens.Home
import com.example.threadclone.screens.Notifications
import com.example.threadclone.screens.Profile
import com.example.threadclone.screens.Register
import com.example.threadclone.screens.Search
import com.example.threadclone.screens.Splash
import com.example.threadclone.screens.login

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController,
        startDestination = Routes.Splash.routes){

        composable(Routes.Splash.routes){
            Splash(navController)
        }
        composable(Routes.Home.routes){
            Home()
        }
        composable(Routes.Notification.routes){
            Notifications()
        }
        composable(Routes.Search.routes){
            Search()
        }
        composable(Routes.AddThreads.routes){
            AddThreads()
        }
        composable(Routes.Profile.routes){
            Profile()
        }
        composable(Routes.BottomNav.routes){
            BottomNav(navController)
        }

        composable(Routes.Login.routes){
            login(navController)
        }

        composable(Routes.Register.routes){
            Register(navController)
        }

    }

}