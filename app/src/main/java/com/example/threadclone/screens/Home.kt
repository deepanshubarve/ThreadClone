package com.example.threadclone.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.getValue

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.threadclone.R
import com.example.threadclone.itemView.ThreadItem
import com.example.threadclone.viewmodel.HomeViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Home(navHostController: NavHostController){

    val homeViewModel : HomeViewModel = viewModel()
    val threadsAndUsers by homeViewModel.threadAndUser.observeAsState(null)
    val context = LocalContext.current


    Column(){


        Image(painter = painterResource(id = R.drawable.thread), contentDescription = "Logo",
            modifier = Modifier.align(Alignment.CenterHorizontally).height(70.dp).fillMaxWidth())


        LazyColumn {
            items(threadsAndUsers ?: emptyList()) { Pair ->
                ThreadItem(
                    thread = Pair.first, users = Pair.second, navHostController,
                    FirebaseAuth.getInstance().currentUser!!.uid
                )


            }
        }

    }


}

@Preview
@Composable
fun HomePreview(){
    //Home()
}