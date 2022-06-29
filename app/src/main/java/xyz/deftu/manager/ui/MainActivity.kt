package xyz.deftu.manager.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.deftu.manager.ui.screens.AboutScreen
import xyz.deftu.manager.ui.screens.HomeScreen
import xyz.deftu.manager.ui.theme.Themed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun Content() {
    Themed {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomBar.Compose(navController) }
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomBar.home.route
            ) {
                composable(BottomBar.home.route) { HomeScreen() }
                composable(BottomBar.about.route) { AboutScreen() }
                composable(BottomBar.settings.route) { SettingsScreen() }
            }
        }
    }
}

@Preview(name = "Light Mode Preview", showBackground = true)
@Preview(name = "Dark Mode Preview", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    Content()
}
