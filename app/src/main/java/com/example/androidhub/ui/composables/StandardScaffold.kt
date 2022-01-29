package com.example.androidhub.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.QuestionAnswer
import androidx.compose.material.icons.outlined.School
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.androidhub.navigation.Screen
import com.example.androidhub.ui.theme.PrimaryBackground

private val bottomNavItemsList = listOf(
    BottomNavItem(
        route = Screen.LearnScreen.route,
        icon = Icons.Outlined.School,
        title = "Learn",
        contentDescription = "Learn BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.CommunityScreen.route,
        icon = Icons.Outlined.Group,
        title = "Community",
        contentDescription = "Community BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.CodeScreen.route,
        icon = Icons.Outlined.Code,
        title = "Code",
        contentDescription = "Code BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.DiscussScreen.route,
        icon = Icons.Outlined.QuestionAnswer,
        title = "Discuss",
        contentDescription = "Discuss BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.ProfileScreen.route,
        icon = Icons.Default.AccountCircle,
        title = "Profile",
        contentDescription = "Profile BottomNavItem"
    )
)

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = bottomNavItemsList,
    Content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation(backgroundColor = PrimaryBackground) {
                    bottomNavItems.forEachIndexed { _, bottomNavItem ->
                        BottomNavItem(
                            name = bottomNavItem.title,
                            icon = bottomNavItem.icon,
                            contentDescription = bottomNavItem.contentDescription,
                            selected = bottomNavItem.route == navController.currentDestination?.route
                        ) {
                            if (navController.currentDestination?.route != bottomNavItem.route) {
                                navController.navigate(bottomNavItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id)
                                }
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Content()
        }
    }
}

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String,
    val contentDescription: String
)
