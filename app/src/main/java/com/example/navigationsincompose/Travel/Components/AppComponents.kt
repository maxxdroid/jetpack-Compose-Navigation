package com.example.navigationsincompose.Travel.Components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationsincompose.ui.theme.GrayColor
import com.example.navigationsincompose.ui.theme.Primary

@Composable
fun NormalTextComponent (value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = GrayColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent (value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = GrayColor,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(label: String, fieldIcon: ImageVector) {
    val textValue = remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        //Rounded Rectangular Border
//        modifier = Modifier.fillMaxWidth().border(
//            BorderStroke(1.dp, GrayColor),
//            shape = RoundedCornerShape(50)
//        ),
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp)),

        label= {Text( text =  label)},
        value = textValue.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        leadingIcon = {
                      Icon(imageVector = fieldIcon, contentDescription = "", tint = GrayColor)
        },
        onValueChange = {
            textValue.value = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(label: String, fieldIcon: ImageVector) {
    val password = remember{
        mutableStateOf("")
    }

    val passwordVisibility = remember{ mutableStateOf(false) }
    OutlinedTextField(
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp)),

        label= {Text( text =  label)},
        value = password.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        trailingIcon = {

            val iconImage = if (passwordVisibility.value) {
                Icons.Filled.Visibility
            } else {
                    Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisibility.value) {
                "Show Password"
            } else {
                "Hide Password"
            }

            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                Icon(imageVector = iconImage, contentDescription = description, tint = GrayColor)
            }
        },
        visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = {
            Icon(imageVector = fieldIcon, contentDescription = "", tint = GrayColor)
        },
        onValueChange = {
            password.value = it
        }
    )
}

@Composable
fun CheckBoxComposable (value: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value != checkedState.value
        })

        ClickableTextComponent(value = value)
    }
}

@Composable
fun ClickableTextComponent(value: String) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = "and"
    val termsAndConditions = ""

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = termsAndConditions, annotation = termsAndConditions)
            append(termsAndConditions)
        }
    }

    ClickableText(text = annotatedString, onClick = {
        span -> Log.d("Clickable Text Component", "{$span}")
    })
}

@Composable
@Preview
fun ShowComponent() {
    Surface (modifier = Modifier.fillMaxSize()) {
        Column {
            MyTextField(label = "Compose", fieldIcon = Icons.Outlined.Build)
            PasswordTextField(label = "Password", fieldIcon = Icons.Outlined.Lock)
        }
    }
}

