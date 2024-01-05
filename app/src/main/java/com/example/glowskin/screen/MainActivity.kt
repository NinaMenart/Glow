package com.example.glowskin.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.glowskin.comps.HeadingText
import com.example.glowskin.comps.ListItem
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
    val parentnavController = rememberNavController()
    var isLoggedIn by remember { mutableStateOf(false) }

    NavHost(navController = parentnavController, startDestination = if (isLoggedIn) "main" else "login") {
        composable("main") {
            MainScreen()

        }
        composable("login") {
            LoginScreen(navController = parentnavController) {
                isLoggedIn = it
                if (isLoggedIn) {
                    parentnavController.navigate("main")
                }
            }
        }
        composable("register") {
            RegisterScreen(true, navController = parentnavController)

        }
        composable("registerConfirm") {
            LoginScreen(navController = parentnavController)

        }
    }

}


@Composable
fun LoginScreen(navController: NavHostController, onLogin: (Boolean) -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LoginForm(onLogin, ::registerOnClick, navController)
    }
}
@Composable
fun RegisterScreen(registerConfirmOnClick: Boolean, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        RegisterForm(::registerConfirmOnClick, navController)
    }
}
fun registerOnClick(isRegistered: Boolean, navController: NavHostController) {
    navController.navigate("register")

    Log.d("LOGIN", "register click happened$isRegistered")

}
fun registerConfirmOnClick(isRegisteredConfirm: Boolean, navController: NavHostController) {
    navController.navigate("registerConfirm")

    Log.d("LOGIN", "registerconfirm click happened$isRegisteredConfirm")

}


@Composable
fun ListScreen(itemList: List<ListItem>) {
    Column {
        HeadingText(value = "Izdelki")
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(itemList) { item ->
                ListItemCard(item = item)
                Divider()
            }
        }
    }
}

@Composable
fun AddScreen(navController: NavHostController) {
    var newItemList by remember { mutableStateOf(emptyList<ListItem>()) }

    Column {
        HeadingText(value = "Dodaj v rutino")
        Spacer(modifier = Modifier.height(16.dp))

        AddedScreen(navController, onItemAdded = { newItem ->
            newItemList = newItemList + newItem
        })
    }
}

@Composable
fun SettingsScreen(navController: NavHostController) {

}

@Composable
fun UserScreen(navController: NavHostController) {

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

    }
}