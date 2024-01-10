package com.example.navigationsincompose.screens

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

data class BottomNavigationItem (
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int?=null
)


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TravelHome(navController: NavController?=null) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        val items = listOf(
            BottomNavigationItem(
                title = "home",
                selectedIcon = Icons.Filled.Home,
                unSelectedIcon = Icons.Outlined.Home,
                hasNews = true
            ),
            BottomNavigationItem(
                title = "chat",
                selectedIcon = Icons.Filled.Email,
                unSelectedIcon = Icons.Outlined.Email,
                hasNews = true,
                badgeCount = 25
            ),
            BottomNavigationItem(
                title = "settings",
                selectedIcon = Icons.Filled.Settings,
                unSelectedIcon = Icons.Outlined.Settings,
                hasNews = true
            ),
        )
        Scaffold (
            bottomBar = {
                NavigationBar {
                   items.forEachIndexed{ index, item -> NavigationBarItem(
                       selected = selectedItemIndex == index,
                       onClick = {
                           selectedItemIndex = index
                           navController?.navigate(item.title)
                       },
                       label = {item.title},
                       icon = { BadgedBox(badge = {
                           if (item.badgeCount != null) {
                               Badge {
                                   Text(text = item.badgeCount.toString())
                               }
                           }  else if (item.hasNews) {
                               Badge()
                           }
                       }) {
                       Icon(imageVector = if (index == selectedItemIndex) {item.selectedIcon} else item.unSelectedIcon, contentDescription = item.title)
                       }}) }
                }
            }
        ) {
            Column {
                Text(text = "HI")
            }
        }
    }
}

@Composable
@Preview
fun PreviewNavigationBar () {
    TravelHome()
}