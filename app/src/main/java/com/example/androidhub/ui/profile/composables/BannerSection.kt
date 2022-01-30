package com.example.androidhub.ui.profile.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidhub.R
import com.example.androidhub.ui.theme.DarkBackground
import com.example.androidhub.ui.theme.Orange

@Composable
fun BannerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(DarkBackground)
    ) {
        Image(
            painter = painterResource(id = R.drawable.demo_2),
            contentDescription = "Profile Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .background(DarkBackground, shape = RoundedCornerShape(5.dp))
                .padding(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Icon",
                modifier = Modifier.size(15.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.bulbasaur),
            contentDescription = "User Profile Image",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(100.dp))
                .border(1.dp, Orange, RoundedCornerShape(100.dp))
                .align(Alignment.BottomCenter)
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 60.dp)
                .height(15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.kotlin_icon),
                contentDescription = "Kotlin Icon",
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 60.dp)
                .height(18.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.github_icon),
                contentDescription = "Github Icon",
                modifier = Modifier.padding(end = 10.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.instagram_icon),
                contentDescription = "Instagram Icon",
                modifier = Modifier.padding(end = 10.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.linkedin_icon),
                contentDescription = "Linkedin Icon",
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }
}
