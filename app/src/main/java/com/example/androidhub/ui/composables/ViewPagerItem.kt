package com.example.androidhub.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhub.ui.theme.DarkBackground
import com.example.androidhub.ui.theme.TextDarkGray

@Composable
fun ViewPagerItem(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Column(modifier = modifier
        .background(DarkBackground)
        .clickable { onClick() }
    ) {
        Text(
            text = title, color = TextDarkGray,
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        if (isSelected) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = TextDarkGray)
            )
        }
    }
}