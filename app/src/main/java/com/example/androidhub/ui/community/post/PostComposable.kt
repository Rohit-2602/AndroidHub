package com.example.androidhub.ui.community.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MapsUgc
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhub.R
import com.example.androidhub.ui.theme.Orange
import com.example.androidhub.ui.theme.TextGray

@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    username: String,
    postDescription: String,
    postedOn: String
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.bulbasaur),
                contentDescription = "User Profile Image",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .border(1.dp, Orange, RoundedCornerShape(30.dp))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            ) {
                Text(text = username, fontSize = 14.sp, color = TextGray)
                Text(text = postedOn, fontSize = 12.sp, color = TextGray)
            }
            Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "More Options")
        }
        Text(
            text = postDescription,
            fontSize = 14.sp,
            color = TextGray,
            modifier = Modifier.padding(top = 10.dp)
        )
        PostContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Like",
                modifier = Modifier.padding(end = 10.dp),
                tint = TextGray
            )
            Icon(
                imageVector = Icons.Outlined.MapsUgc,
                contentDescription = "Comment",
                modifier = Modifier.padding(end = 10.dp),
                tint = TextGray
            )
            Icon(
                imageVector = Icons.Outlined.Send,
                contentDescription = "Share",
                modifier = Modifier.padding(end = 10.dp),
                tint = TextGray
            )
        }
    }
}

@Composable
fun PostContent(
    modifier: Modifier = Modifier
) {
    var currentImage by remember {
        mutableStateOf(1)
    }
    val imageList = listOf(
        painterResource(id = R.drawable.demo),
        painterResource(id = R.drawable.demo_1),
        painterResource(id = R.drawable.demo_2),
        painterResource(id = R.drawable.demo_3),
    )
    Box(modifier = modifier) {
        LazyRow(Modifier.fillMaxWidth()) {
            itemsIndexed(imageList) { index, item ->
                Image(
                    painter = item,
                    contentDescription = "Image",
                    modifier = Modifier,
                    contentScale = ContentScale.Crop
                )
            }
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ) {
            Text(
                text = "$currentImage/${imageList.size}",
                fontSize = 12.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}