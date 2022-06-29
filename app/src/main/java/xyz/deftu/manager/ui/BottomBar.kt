package xyz.deftu.manager.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

object BottomBar {
    val home = BottomBarItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    val about = BottomBarItem(
        route = "about",
        title = "About",
        icon = Icons.Default.Info
    )
    val settings = BottomBarItem(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )

    @Composable
    fun Compose(nav: NavHostController) {
        val items = listOf(home, about, settings)
        val entry by nav.currentBackStackEntryAsState()
        val currentDestination = entry?.destination
        BottomNavigation(
            backgroundColor = Color(0xFF990000)
        ) {
            for (item in items) {
                AddItem(item = item, currentDestination = currentDestination, nav = nav)
            }
        }
    }
}

data class BottomBarItem(
    val route: String,
    val title: String,
    val icon: ImageVector? = null
)

@Composable
private fun RowScope.AddItem(
    item: BottomBarItem,
    currentDestination: NavDestination?,
    nav: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(
                text = item.title,
                color = Color.White
            )
        },
        icon = {
            item.icon?.let { Icon(
                imageVector = it,
                tint = Color.White,
                contentDescription = "Navigation Icon"
            ) }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == item.route
        } == true,
        onClick = {
            nav.navigate(item.route)
        }
    )
}
