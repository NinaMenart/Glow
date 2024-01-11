package com.example.glowskin.screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glowskin.comps.BottomNavBar
import com.example.glowskin.comps.BottomNavItem

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

fun MainScreen(viewModel: RoutineViewModel) {
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
                        icon = Icons.Default.FavoriteBorder
                    ),
                    BottomNavItem(
                        route = "add",
                        icon = Icons.Default.List
                    ),
                    BottomNavItem(
                        route = "user",
                        icon = Icons.Default.ThumbUp
                    ),
                ),
                navController = childnavController,
                onItemClick = {
                    childnavController.navigate(it.route)
                }
            )
        }
    ) {
        ChildNavigation(childnavController, viewModel)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildNavigation(navController: NavHostController, viewModel: RoutineViewModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("list") {
            ListScreen(navController = navController)

        }
        composable("add") {
            AddScreen(navController = navController, viewModel)
        }


        composable("user") {
            UserScreen(navController = navController)

        }
    }
}




