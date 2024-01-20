package com.example.navigationsincompose.Travel.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationsincompose.R
import com.example.navigationsincompose.Travel.Components.CheckBoxComposable
import com.example.navigationsincompose.Travel.Components.HeadingTextComponent
import com.example.navigationsincompose.Travel.Components.MyTextField
import com.example.navigationsincompose.Travel.Components.NormalTextComponent
import com.example.navigationsincompose.Travel.Components.PasswordTextField

@Composable
fun SignUpScreen () {
    Surface (
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = "Hello There,")

            HeadingTextComponent(value = "Create An Account")

            //Sized Box in kotlin is Spacer
            Spacer(modifier = Modifier.heightIn(20.dp))

            MyTextField(label = "First Name", fieldIcon = Icons.Outlined.Person)
            MyTextField(label = "Last Name", fieldIcon = Icons.Outlined.Person)
            MyTextField(label = "Email", fieldIcon = Icons.Outlined.Email)
            PasswordTextField(label = "Password", fieldIcon = Icons.Outlined.Lock)

            CheckBoxComposable(value = stringResource(id =  R.string.terms_and_conditions))
        }
    }
}

@Composable
@Preview
fun ShowSignUpScreen () {
    SignUpScreen()
}