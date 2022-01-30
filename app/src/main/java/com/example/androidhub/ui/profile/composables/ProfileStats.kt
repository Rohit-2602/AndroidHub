package com.example.androidhub.ui.profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androidhub.ui.theme.TextGray

@Composable
fun ProfileStats(modifier: Modifier = Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        ProfileStatItem(field = "Followers", value = "30")
        ProfileStatItem(field = "Following", value = "20")
        ProfileStatItem(field = "Posts", value = "1")
        ProfileStatItem(field = "Articles", value = "0")
    }
}

@Composable
fun ProfileStatItem(
    field: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = field, fontSize = 12.sp, color = TextGray)
    }
}