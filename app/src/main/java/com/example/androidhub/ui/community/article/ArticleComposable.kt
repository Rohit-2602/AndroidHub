package com.example.androidhub.ui.community.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhub.R
import com.example.androidhub.ui.theme.Orange
import com.example.androidhub.ui.theme.TextDarkGray
import com.example.androidhub.ui.theme.TextGray

@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    username: String,
    articleTitle: String,
    articleDescription: String,
    articlePostedOn: String
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
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
            Text(
                text = username,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 14.sp,
                color = TextGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Column(modifier = Modifier.weight(1f).padding(end = 10.dp)) {
                Text(
                    text = articleTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextGray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = articleDescription,
                    fontSize = 14.sp,
                    color = TextDarkGray,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.demo),
                contentDescription = "Article Thumbnail",
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = articlePostedOn,
                fontSize = 14.sp,
                color = TextDarkGray,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Outlined.BookmarkAdd,
                contentDescription = "Bookmark",
                modifier = Modifier.padding(end = 20.dp),
                tint = TextDarkGray
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options",
                modifier = Modifier.padding(end = 10.dp),
                tint = TextDarkGray
            )
        }
    }
}