package com.example.androidhub.ui.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidhub.ui.community.article.CommunityArticleScreen
import com.example.androidhub.ui.community.post.CommunityPostScreen
import com.example.androidhub.ui.composables.ViewPagerItem

@Composable
fun CommunityScreen(
    navController: NavController,
    viewModel: CommunityViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ViewPagerItem(
                title = "Posts",
                modifier = Modifier.weight(1f),
                isSelected = viewModel.selectedScreen.value == 1
            ) {
                viewModel.setSelectedScreen(1)
            }
            ViewPagerItem(
                title = "Articles",
                modifier = Modifier.weight(1f),
                isSelected = viewModel.selectedScreen.value == 2
            ) {
                viewModel.setSelectedScreen(2)
            }
        }
        Scaffold {
            if (viewModel.selectedScreen.value == 1) {
                CommunityPostScreen(navController = navController)
            } else {
                CommunityArticleScreen(navController = navController)
            }
        }
    }

}