package com.example.androidhub.ui.learn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidhub.ui.composables.StandardAppBar
import com.example.androidhub.ui.learn.composables.TopicItem
import com.example.androidhub.ui.theme.DarkBackground

@Composable
fun LearnScreen(
    navController: NavController
) {

    Column(modifier = Modifier.fillMaxSize().background(DarkBackground)) {
        StandardAppBar(
            navController = navController,
            Title = {
                Text(
                    text = "Android",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
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
        LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
            items(5) {
                TopicItem(topicTitle = "Basics")
            }
        }
    }

}