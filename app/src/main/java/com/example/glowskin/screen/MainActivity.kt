package com.example.glowskin.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.glowskin.comps.BottomNavItem
import com.example.glowskin.ui.theme.Coffee
import com.example.glowskin.ui.theme.GlowSkinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlowSkinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val navController = rememberNavController()
    var isLoggedIn by remember { mutableStateOf(false) }

    // Set up the navigation
    NavHost(navController = navController, startDestination = if (isLoggedIn) "main" else "login") {
        composable("main") {
            MainScreen(navController)

        }
        composable("login") {
            LoginScreen(navController = navController) {
                isLoggedIn = it
            }
        }
        composable("list") {
            ListScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("main") {
            MainScreen(navController = navController)

        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("list") {
            ListScreen(navController = navController)

        }
    }
}


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(
                items = listOf(
                    BottomNavItem(
                        route = "main",
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
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "main screen")
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController, onLogin: (Boolean) -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LoginForm { isLoggedIn ->
            onLogin(isLoggedIn)
            if (isLoggedIn) {
                navController.navigate("main")
            }
        }
    }
}

@Composable
fun ListScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "list screen")
    }
}

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        modifier = modifier,
        containerColor = Coffee,
        tonalElevation = 2.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Coffee,
                    unselectedIconColor = Color.White
                ),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.route)
                    }
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GlowSkinTheme {
        val navController = rememberNavController()
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
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) {
            Navigation(navController = navController)
        }
    }
}
