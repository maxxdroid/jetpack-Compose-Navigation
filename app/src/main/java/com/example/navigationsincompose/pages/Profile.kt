package com.example.navigationsincompose.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ProfileScreen() {
    Box (modifier = Modifier.fillMaxSize().background(color = Color.Cyan), contentAlignment = Alignment.Center) {
        Text(text = "Profile", fontSize = MaterialTheme.typography.displayLarge.fontSize)
    }
}

@Composable
@Preview
fun PreviewProfile() {
    ProfileScreen()
}