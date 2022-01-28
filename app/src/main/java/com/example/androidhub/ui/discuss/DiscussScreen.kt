package com.example.androidhub.ui.discuss

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DiscussScreen(
    navController: NavController
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(count = 20) {
            QuestionItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp)
                    .background(color = MaterialTheme.colors.secondary)
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