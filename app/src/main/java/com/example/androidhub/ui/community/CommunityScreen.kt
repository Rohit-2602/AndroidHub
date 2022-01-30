package com.example.androidhub.ui.community

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidhub.ui.community.article.CommunityArticleScreen
import com.example.androidhub.ui.community.post.CommunityPostScreen
import com.example.androidhub.ui.composables.StandardAppBar
import com.example.androidhub.ui.composables.ViewPagerItem

@Composable
fun CommunityScreen(
    navController: NavController,
    viewModel: CommunityViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize()) {
        StandardAppBar(
            navController = navController,
            Title = {
                Text(
                    text = "Community",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                        .padding(start = 15.dp)
                )
            }, NavActions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Action Notification"
                    )
                }
            }
        )
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