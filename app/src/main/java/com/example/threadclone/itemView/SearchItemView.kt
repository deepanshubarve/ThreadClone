package com.example.threadclone.itemView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.threadclone.model.UserModel

@Composable
fun SearchItem(
    users : UserModel,
    navHostController: NavHostController
){

    Column {
        ConstraintLayout(modifier = Modifier.padding(16.dp)) {

            val (userImage, userName, date, time, title, image) = createRefs()

            Image(
                painter = rememberAsyncImagePainter(model = users.imageUrl),
                contentDescription = "userImage",
                modifier = Modifier.constrainAs(userImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 12.dp)
                }.size(36.dp).clip(CircleShape), contentScale = ContentScale.Crop
            )


            Text(
                text = users.username, style = TextStyle(
                    fontSize = 22.sp
                ), modifier = Modifier.constrainAs(userName) {
                    top.linkTo(userImage.top)
                    start.linkTo(userImage.end, margin = 12.dp)
                }
            )

            Text(
                text = users.name, style = TextStyle(
                    fontSize = 16.sp
                ), modifier = Modifier.constrainAs(title) {
                    top.linkTo(userName.bottom)
                    start.linkTo(userName.start)
                }
            )
        }
        Divider(color = Color.LightGray, thickness = 1.dp)

    }
}
