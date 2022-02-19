package com.example.androidhub.ui.learn.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhub.ui.theme.Blue
import com.example.androidhub.ui.theme.TextGray

@Composable
fun TopicItem(
    topicTitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            }
    ) {
        Column(modifier = Modifier.padding(start = 10.dp, end = 20.dp)) {
            Image(
                imageVector = Icons.Default.Book,
                contentDescription = "Topic Icon",
                modifier = Modifier
                    .size(60.dp)
                    .background(color = Blue, shape = RoundedCornerShape(50.dp))
                    .padding(15.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Divider(
                modifier = Modifier
                    .height(25.dp)
                    .width(2.dp)
                    .padding(top = 5.dp, bottom = 5.dp)
                    .align(Alignment.CenterHorizontally),
                color = Blue
            )
        }
        Text(
            text = topicTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = TextGray,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}