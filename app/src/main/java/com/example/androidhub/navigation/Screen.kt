package com.example.androidhub.navigation

sealed class Screen(val route: String) {

    // Auth
    object LoginScreen: Screen("Login")
    object SignUpScreen: Screen("SignUp")

    // Main
    object LearnScreen: Screen("Learn")
    object CommunityScreen: Screen("Community")
    object CodeScreen: Screen("Code")
    object DiscussScreen: Screen("Discuss")
    object ProfileScreen: Screen("Profile")

}