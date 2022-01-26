package com.example.androidhub.ui.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.androidhub.navigation.Screen
import com.example.androidhub.ui.composables.BasicTextInput

@Composable
fun SignUpScreen(
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
            Spacer(modifier = Modifier.weight(weight = 1.0f))
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = "Already have a account account? ")
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.LoginScreen.route) {
                            popUpTo(Screen.LoginScreen.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Header() {
    Text(
        text = "Create Account",
        style = TextStyle(color = Color.White),
        fontSize = 30.sp,
        modifier = Modifier.padding(top = 60.dp),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "Please Fill The Input Below Here",
        style = TextStyle(color = Color.White),
        modifier = Modifier.padding(top = 10.dp),
        fontSize = 15.sp
    )
}

@Composable
fun TextFields(
    navController: NavHostController,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
    BasicTextInput(
        text = signUpViewModel.userNameText.value,
        hint = "UserName",
        error = signUpViewModel.userNameError.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp),
        onValueChange = { signUpViewModel.setUserNameText(it) },
        keyboardType = KeyboardType.Email
    )
    BasicTextInput(
        text = signUpViewModel.emailText.value,
        hint = "Email",
        error = signUpViewModel.emailError.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        onValueChange = { signUpViewModel.setEmailText(it) },
        keyboardType = KeyboardType.Email
    )
    BasicTextInput(
        text = signUpViewModel.passwordText.value,
        hint = "Password",
        error = signUpViewModel.passwordError.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        onValueChange = { signUpViewModel.setPasswordText(it) },
        showPasswordToggle = signUpViewModel.showPassword.value,
        onPasswordToggleClick = {
            signUpViewModel.setShowPassword(it)
        },
        keyboardType = KeyboardType.Password
    )
    BasicTextInput(
        text = signUpViewModel.confirmPasswordText.value,
        hint = "Re-Enter Password",
        error = signUpViewModel.confirmPasswordError.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        onValueChange = { signUpViewModel.setConfirmPasswordText(it) },
        showPasswordToggle = signUpViewModel.showConfirmPassword.value,
        onPasswordToggleClick = {
            signUpViewModel.setShowConfirmPassword(it)
        },
        keyboardType = KeyboardType.Password
    )
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            modifier = Modifier
                .padding(top = 40.dp),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary
            )
        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
            )
        }
    }
}