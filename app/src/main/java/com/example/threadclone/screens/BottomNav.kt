package com.example.threadclone.screens

import android.app.FragmentManager.BackStackEntry
import android.app.Notification
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.threadclone.model.BottomNavItems
import com.example.threadclone.navigation.Routes


@Composable
fun BottomNav(navController: NavHostController){

    var navController1 = rememberNavController()

   Scaffold (bottomBar = {MyBottombar(navController1)}){innerPadding ->
       NavHost(navController = navController1, startDestination = Routes.Home.routes,
       modifier = Modifier.padding(innerPadding)){
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
               Profile(navController)
           }

       }
   }
}

@Composable
fun MyBottombar(navController1: NavHostController){

    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItems(
            "Home",
            Routes.Home.routes,
            Icons.Rounded.Home
        ),
        BottomNavItems(
            "Search",
            Routes.Search.routes,
            Icons.Rounded.Search
        ),
        BottomNavItems(
            "Notification",
            Routes.Notification.routes,
            Icons.Rounded.Notifications
        ),
        BottomNavItems(
            "Add Threads",
            Routes.AddThreads.routes,
            Icons.Rounded.Add
        ),
        BottomNavItems(
            "Profile",
            Routes.Profile.routes,
            Icons.Rounded.Person
        )
    )

    BottomAppBar {
        list.forEach{

            val selected = it.route == backStackEntry?.value?.destination?.route

            NavigationBarItem(selected = selected, onClick = {
                navController1.navigate(it.route){
                    popUpTo(navController1.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                }}, icon = {
              Icon(imageVector = it.icon, contentDescription = it.title)

            })
        }
    }
}
