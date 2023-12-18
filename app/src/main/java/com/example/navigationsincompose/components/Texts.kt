package com.example.navigationsincompose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        fontSize = 28.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 15.dp, bottom = 12.dp)
    )
}

@Composable
fun NormalText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp)
    )
}