package com.example.androidhub.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidhub.navigation.Screen
import com.example.androidhub.navigation.SetUpNavGraph
import com.example.androidhub.ui.composables.StandardScaffold
import com.example.androidhub.ui.theme.AndroidHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidHubTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.LearnScreen.route,
                            Screen.CommunityScreen.route,
                            Screen.CodeScreen.route,
                            Screen.DiscussScreen.route,
                            Screen.ProfileScreen.route
                        )
                    ) {
                        SetUpNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}