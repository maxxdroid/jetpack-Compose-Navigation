package com.example.navigationsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.navigationsincompose.Travel.auth.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MainContent()
//            BottomMainScreen()
            SignUpScreen()
        }
    }
}
