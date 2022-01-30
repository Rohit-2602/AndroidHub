package com.example.androidhub.ui.discuss

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidhub.ui.composables.StandardAppBar
import com.example.androidhub.ui.theme.DarkBackground

@Composable
fun DiscussScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardAppBar(
            navController = navController,
            Title = {
                Text(
                    text = "Discuss",
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
        LazyColumn {
            items(count = 20) {
                QuestionItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp)
                        .background(color = DarkBackground)
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                    userName = "Rohit Sharma",
                    userProfileImage = Icons.Default.Person,
                    timeAgo = "4 hours Ago",
                    questionTitle = "This is the title of the question.",
                    questionDescription = "This is the description of the question",
                    tagsList = listOf("android", "kotlin", "compose"),
                    votes = "100",
                    answers = "101",
                    views = "102"
                )
            }
        }
    }
}