package com.example.androidhub.ui.composables

import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.androidhub.navigation.Screen

private val bottomNavItemsList = listOf(
    BottomNavItem(
        route = Screen.LearnScreen.route,
        icon = Icons.Default.School,
        title = "Learn",
        contentDescription = "Learn BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.CommunityScreen.route,
        icon = Icons.Filled.Group,
        title = "Community",
        contentDescription = "Community BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.CodeScreen.route,
        icon = Icons.Default.Book,
        title = "Code",
        contentDescription = "Code BottomNavItem"
    ),
    BottomNavItem(
        route = Screen.DiscussScreen.route,
        icon = Icons.Default.QuestionAnswer,
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
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation {
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
    ) {
        content()
    }
}

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String,
    val contentDescription: String
)
