package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import ui.components.ButtonBar
import ui.screens.About
import ui.screens.HidrasiDetail
import ui.screens.Home
import ui.screens.Resep
import ui.screens.ResepDetail
import ui.screens.SnackDetail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                    ButtonBar(
                        onHomeClick = { navController.navigate("home") },
                        onResepClick = { navController.navigate("resep") },
                        onProfileClick = { navController.navigate("profile") }
                    )
                }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable("home") {
                            Home(navController = navController)
                        }
                        composable("snackDetail/{snackId}") { backStackEntry ->
                            val snackId = backStackEntry.arguments?.getString("snackId")?.toInt() ?: 0
                            SnackDetail(snackId = snackId, navController = navController)
                        }
                        composable("juiceDetail/{juiceId}") { backStackEntry ->
                            val juiceId = backStackEntry.arguments?.getString("juiceId")?.toInt() ?: 0
                            HidrasiDetail(juiceId = juiceId, navController = navController)
                        }
                        composable("resep") {
                            Resep(navController = navController)
                        }
                        composable("resep_detail/{recipeId}") { backStackEntry ->
                            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toInt() ?: 0
                            ResepDetail(recipeId = recipeId, navController = navController)
                        }
                        composable("profile") {
                            About(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}