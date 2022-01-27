package com.example.androidhub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidhub.ui.code.CodeScreen
import com.example.androidhub.ui.community.CommunityScreen
import com.example.androidhub.ui.discuss.DiscussScreen
import com.example.androidhub.ui.learn.LearnScreen
import com.example.androidhub.ui.login.LoginScreen
import com.example.androidhub.ui.profile.ProfileScreen
import com.example.androidhub.ui.signup.SignUpScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.LearnScreen.route) {
            LearnScreen(navController = navController)
        }

        composable(route = Screen.CommunityScreen.route) {
            CommunityScreen(navController = navController)
        }

        composable(route = Screen.CodeScreen.route) {
            CodeScreen(navController = navController)
        }

        composable(route = Screen.DiscussScreen.route) {
            DiscussScreen(navController = navController)
        }

        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }

    }
}