package com.example.navigationsincompose.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomMainScreen () {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar (navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach {
            screen -> AddItem(
            screen = screen,
            currentDestination = currentDestination ,
            navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem (
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        selected = currentDestination?.hierarchy?.any() {it.route == screen.route
        } == true,
        onClick = {
                  navController.navigate(screen.route)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        }
    )
}

@Composable
@Preview
fun Seee () {
    BottomMainScreen()
}