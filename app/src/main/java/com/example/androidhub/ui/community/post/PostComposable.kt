package com.example.androidhub.ui.community.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MapsUgc
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhub.R
import com.example.androidhub.ui.theme.LightBackground
import com.example.androidhub.ui.theme.Orange
import com.example.androidhub.ui.theme.TextGray
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostContent(
    modifier: Modifier = Modifier
) {
    val imageList = listOf(
        painterResource(id = R.drawable.demo),
        painterResource(id = R.drawable.demo_1),
        painterResource(id = R.drawable.demo_2),
        painterResource(id = R.drawable.demo_3),
    )
    val pageState = rememberPagerState(pageCount = imageList.size)
    HorizontalPager(state = pageState, modifier = modifier) { page ->
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = imageList[page],
                contentDescription = "Image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(LightBackground)
            ) {
                Text(
                    text = "${pageState.currentPage+1}/${imageList.size}",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                )
            }
        }
    }
}