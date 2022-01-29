package com.example.androidhub.ui.community.article

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
fun CommunityArticleScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(20) {
            ArticleItem(
                username = "Rohit Sharma",
                articleTitle = "How to use Compose LazyColumn.",
                articleDescription = "This is the Description of the Article.",
                articlePostedOn = "Oct 21, 2021",
                modifier = Modifier.padding(bottom = 2.dp)
                    .background(DarkBackground)
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            )
        }
    }
}