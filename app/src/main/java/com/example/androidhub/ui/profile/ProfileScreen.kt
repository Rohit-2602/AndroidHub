package com.example.androidhub.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidhub.ui.community.article.ArticleItem
import com.example.androidhub.ui.community.post.PostItem
import com.example.androidhub.ui.composables.ViewPagerItem
import com.example.androidhub.ui.profile.composables.BannerSection
import com.example.androidhub.ui.profile.composables.ProfileHeader
import com.example.androidhub.ui.theme.DarkBackground

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BannerSection()
        }
        item {
            ProfileHeader()
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBackground)
                    .padding(top = 10.dp)
            ) {
                ViewPagerItem(
                    title = "Posts",
                    modifier = Modifier.weight(1f),
                    isSelected = viewModel.selectedTab.value == 1
                ) {
                    viewModel.setSelectedTab(1)
                }
                ViewPagerItem(
                    title = "Articles",
                    modifier = Modifier.weight(1f),
                    isSelected = viewModel.selectedTab.value == 2
                ) {
                    viewModel.setSelectedTab(2)
                }
            }
        }
        items(20) {
            if (viewModel.selectedTab.value == 1) {
                PostItem(
                    username = "Rohit Sharma",
                    postDescription = "This Post contains some Random Images.",
                    postedOn = "Jan 30, 2022",
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                        .background(DarkBackground)
                        .padding(10.dp)
                )
            }
        }
        items(20) {
            if (viewModel.selectedTab.value == 2) {
                ArticleItem(
                    username = "Rohit Sharma",
                    articleTitle = "How to use Compose LazyColumn.",
                    articleDescription = "This is the Description of the Article.",
                    articlePostedOn = "Oct 21, 2021",
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                        .background(DarkBackground)
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                )
            }
        }
    }
}