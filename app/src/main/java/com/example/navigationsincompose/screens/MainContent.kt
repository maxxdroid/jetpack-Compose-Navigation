package com.example.navigationsincompose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface (modifier = Modifier.fillMaxSize())
    {
        NavHost(
            navController = navController,
            startDestination = "travel",) {
            composable("home") {
                Home(navController)
            }
            composable("settings") {
                Home(navController)
            }
            composable("travel") {
                TravelHome(navController)
            }
            composable("task?item={item}", arguments = listOf(navArgument("item"){
                type = NavType.StringType
                defaultValue = "Item     not Available"
                nullable = true
            }) ) {
                val item = it.arguments?.getString("item")
                Task(item = item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MainContent()
}