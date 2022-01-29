package com.example.androidhub.ui.discuss

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhub.R
import com.example.androidhub.ui.theme.LightBackground
import com.example.androidhub.ui.theme.Orange
import com.example.androidhub.ui.theme.TextDarkGray
import com.example.androidhub.ui.theme.TextGray
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun QuestionItem(
    modifier: Modifier = Modifier,
    userName: String,
    userProfileImage: ImageVector,
    timeAgo: String,
    questionTitle: String,
    questionDescription: String,
    tagsList: List<String> = listOf(),
    votes: String,
    answers: String,
    views: String
) {
    Row(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TitleValueText(value = votes, title = "votes")
            TitleValueText(value = answers, title = "answers")
            TitleValueText(value = views, title = "views")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp)
        ) {
            Text(
                text = questionTitle,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = TextGray
            )
            Text(
                text = questionDescription,
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 12.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = TextDarkGray
            )
            FlowRow {
                tagsList.forEach { tag ->
                    TagView(tag = tag)
                }
            }
            Spacer(modifier = Modifier.weight(weight = 1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = "QuestionTimeAgo",
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    tint = TextGray
                )
                Text(
                    text = timeAgo,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 5.dp),
                    color = TextGray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = userName, fontSize = 14.sp,
                    modifier = Modifier
                        .padding(end = 10.dp),
                    color = TextGray
                )
                Image(
                    painter = painterResource(id = R.drawable.bulbasaur),
                    contentDescription = "User Profile Image",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .border(
                            width = 1.dp,
                            color = Orange,
                            shape = RoundedCornerShape(30.dp)
                        )
                )
            }
        }
    }
}

@Composable
fun TitleValueText(value: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Text(text = value, fontSize = 12.sp, color = TextGray)
        Text(text = title, fontSize = 10.sp, color = TextGray)
    }
}

@Composable
fun TagView(tag: String, fontSize: TextUnit = 10.sp) {
    Box(
        modifier = Modifier
            .padding(end = 5.dp, top = 10.dp)
            .background(color = LightBackground, shape = RoundedCornerShape(20.dp))
    ) {
        Text(
            text = tag,
            fontSize = fontSize,
            color = TextGray,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
        )
    }
}
