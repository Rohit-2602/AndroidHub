package com.example.androidhub.ui.community.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidhub.ui.theme.DarkBackground

@Composable
fun CommunityPostScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) {
            PostItem(
                username = "Rohit Sharma",
                postDescription = "This Post contains some Random Images.",
                postedOn = "Jan 30, 2022",
                modifier = Modifier.padding(bottom = 2.dp)
                    .background(DarkBackground)
                    .padding(10.dp)
            )
        }
    }
}