package com.example.glowskin.screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glowskin.comps.BottomNavItem

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

fun MainScreen() {
    val childnavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(
                items = listOf(
                    BottomNavItem(
                        route = "home",
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        route = "list",
                        icon = Icons.Default.Face
                    ),
                    BottomNavItem(
                        route = "login",
                        icon = Icons.Default.AccountCircle
                    ),
                ),
                navController = childnavController,
                onItemClick = {
                    childnavController.navigate(it.route)
                }
            )
        }
    ) {
        ChildNavigation(childnavController)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("list") {
            ListScreen(navController = navController)

        }
    }
}