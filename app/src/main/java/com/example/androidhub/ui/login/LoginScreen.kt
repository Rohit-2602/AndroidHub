package com.example.androidhub.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidhub.navigation.Screen
import com.example.androidhub.ui.TextInput

@Composable
fun LoginScreen(
    navController: NavHostController
) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Header()
            TextFields(navController = navController)
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = "Don't have an account? ")
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.SignUpScreen.route)
                    }
                )
            }
        }
    }

}

@Composable
fun Header() {
    Text(
        text = "Login",
        style = TextStyle(color = Color.White),
        fontSize = 30.sp,
        modifier = Modifier.padding(top = 60.dp),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "Please Sign in to Continue",
        style = TextStyle(color = Color.White),
        modifier = Modifier.padding(top = 10.dp),
        fontSize = 15.sp
    )
}

@Composable
fun TextFields(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    TextInput(
        text = email,
        label = "Email",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp),
        onValueChange = { email = it },
        keyboardType = KeyboardType.Email
    )
    TextInput(
        text = password,
        label = "Password",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        onValueChange = { password = it },
        keyboardType = KeyboardType.Password
    )
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            modifier = Modifier
                .padding(top = 30.dp),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.DarkGray
            )
        ) {
            Text(
                text = "Login",
                style = TextStyle(color = Color.White)
            )
        }
    }
}
