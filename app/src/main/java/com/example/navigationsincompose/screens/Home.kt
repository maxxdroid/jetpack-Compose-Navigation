package com.example.navigationsincompose.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigationsincompose.R
import com.example.navigationsincompose.components.NormalText
import com.example.navigationsincompose.components.TitleText
import com.example.navigationsincompose.ui.theme.NavigationsInComposeTheme


@Composable
fun Home (navController: NavHostController?= null) {
    Column (
        Modifier
            .fillMaxSize()
            .padding(top = 24.dp)) {
        TextField(
            value = "",
            onValueChange = {},
            modifier= Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(5.dp),
            leadingIcon = {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "")
            }
        )
        TitleText(title = "My Tasks")

        LazyColumn{
            var i = 1;
            items((1..4).toList()) {
                TaskCard(task = "Item ${i++}", navController)
            }
        }
    }
}


@Composable
fun TaskCard(task: String, navController: NavHostController? = null) {
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 8.dp).clickable {
                navController?.navigate("task")
            }
    )    {
        Row (
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Image(painter = painterResource(
                id = R.drawable.taskicon),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(40.dp)
                )
            NormalText(text = task)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    Home()
}