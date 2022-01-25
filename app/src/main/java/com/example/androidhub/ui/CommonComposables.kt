package com.example.androidhub.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextInput(
    text: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (text: String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier,
        label = {
            Text(text = label, style = TextStyle(color = Color.White))
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}