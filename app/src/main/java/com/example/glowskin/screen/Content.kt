package com.example.glowskin.screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glowskin.comps.BottomNavItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Content(){
    val internalController = rememberNavController()

    Scaffold (
        bottomBar = {
            BottomNavBar(items = listOf(
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
                navController = internalController,
                onItemClick = {
                    internalController.navigate(it.route)
                })
        }
    ) {
        InternalNavigation(navController = internalController)
    }
}

@Composable
fun InternalNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("home") {
            //home screen kar se kaze
            HomeScreen()

        }
        composable("login") {
            //home screen kar se kaze
            //LoginScreen()
        }
        composable("list") {
            //home screen kar se kaze
            ListScreen()
        }
    }
}