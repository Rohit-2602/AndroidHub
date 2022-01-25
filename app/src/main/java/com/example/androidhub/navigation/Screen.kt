package com.example.androidhub.navigation

sealed class Screen(val route: String) {

    object LoginScreen: Screen("Login")

    object SignUpScreen: Screen("SignUp")

}