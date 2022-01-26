package com.example.androidhub.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.androidhub.navigation.SetUpNavGraph
import com.example.androidhub.ui.theme.AndroidHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidHubTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    SetUpNavGraph(navController = navController)
                }
            }
        }
    }
}