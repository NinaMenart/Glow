package com.example.glowskin.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glowskin.R
import com.example.glowskin.comps.BackgroundImage
import com.example.glowskin.comps.CounterText
import com.example.glowskin.comps.EmptyRoutineText
import com.example.glowskin.comps.HeadingText
import com.example.glowskin.comps.ListItem
import com.example.glowskin.comps.Routine
import com.example.glowskin.ui.theme.GlowSkinTheme
import io.ktor.client.*

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
    BackgroundImage()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LoginForm(onLogin, ::registerOnClick, navController)
    }
}
@Composable
fun RegisterScreen(registerConfirmOnClick: Boolean, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BackgroundImage()
        RegisterForm(::registerConfirmOnClick, navController)
    }
}
fun registerOnClick(isRegistered: Boolean, navController: NavHostController) {
    navController.navigate("register")

    Log.d("LOGIN", "register click happened$isRegistered")

}
fun registerConfirmOnClick(isRegisteredConfirm: Boolean, navController: NavHostController) {
    navController.navigate("login")

    Log.d("LOGIN", "registerconfirm click happened$isRegisteredConfirm")

}


@Composable
fun ListScreen(itemList: List<ListItem>) {

    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFFFC107), Color(0xFF6A005B)),
                        radius = 600f
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo3nb),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp),
            )
            HeadingText(
                value = "Izdelki",
            )
        }
    }
    Column {
        Spacer(modifier = Modifier.height(90.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 66.dp)
        ) {
            item {
                CounterText( "Super izdelki, ki vam pomagajo pri vaših problemih s kožo!")
            }
            items(itemList) { item ->
                ListItemCard(item = item)
                Divider()
            }
        }
    }
}
@Composable
fun AddScreen(navController: NavHostController) {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFFFC107), Color(0xFF6A005B)),
                        radius = 600f
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo3nb),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp),
            )
            HeadingText(
                value = "Moja rutina",
            )
        }
    }


    var routine by remember { mutableStateOf(emptyList<Routine>()) }

    Column {
        Spacer(modifier = Modifier.height(86.dp))

        RoutineListScreen(routine)
        Log.d("ROUTINE", "$routine")

        AddButtonWithDialog { newRutine ->
            routine = routine + newRutine
            Log.d("COUNTER", "$newRutine")
        }
    }
}




@Composable
fun UserScreen(navController: NavHostController) {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFFFC107), Color(0xFF6A005B)),
                        radius = 600f
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo3nb),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp),
            )
            HeadingText(
                value = "Šala",
            )
        }
    }
    Column {
        Spacer(modifier = Modifier.height(86.dp))
    ShowJoke()
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