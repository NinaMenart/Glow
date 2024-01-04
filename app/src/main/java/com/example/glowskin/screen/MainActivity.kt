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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlowSkinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
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
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                })
                        }
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}




@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("home2123") {
            //home screen kar se kaze
            HomeScreen()

        }
        composable("login1231") {
            //home screen kar se kaze
            LoginScreen()
        }
        composable("list3123") {
            //home screen kar se kaze
            ListScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.Center)
    {
        Text(text = "home screen")
    }
}

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.Center)
    {
        LoginForm()
    }
}

@Composable
fun ListScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.Center)
    {
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
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
                        Icon(imageVector = item.icon,
                            contentDescription = item.route
                        )
                    }
                }
            )
        }
    }
}




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GlowSkinTheme {
        val navController = rememberNavController()
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
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    })
            }
        ) {
            Navigation(navController = navController)
        }
    }
}