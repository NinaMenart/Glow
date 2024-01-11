package com.example.glowskin.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.glowskin.R
import com.example.glowskin.ui.theme.Haze
import com.example.glowskin.ui.theme.Sunset

@Composable
fun BackgroundImage(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
}

@Composable
fun CounterText(value:String){
    Text(
        text = value,
        modifier = Modifier
            .padding(0.dp, 5.dp, 0.dp, 0.dp)
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp,
            fontStyle = FontStyle.Normal
        )
        ,
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingText(value:String){
    Text(
        text = value,
        modifier = Modifier
            .padding(0.dp, 5.dp, 0.dp, 0.dp)
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontSize = 52.sp,
            fontStyle = FontStyle.Normal
        )
        ,
        textAlign = TextAlign.Center
    )
}
@Composable
fun WelcomeText(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 55.sp,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun JokeText(jokeText: String) {
    Text(
        text = jokeText,
        modifier = Modifier
            .padding(16.dp)
        ,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
    )

}

@Composable
fun EmptyRoutineText(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 45.sp,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}
@Composable
fun ItemHeadingText(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .padding(4.dp)
        ,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
    )

}
@Composable
fun ItemDescriptionText(description: String) {
    Text(
        text = description,
        modifier = Modifier
        ,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
    )

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
        containerColor = Haze,
        tonalElevation = 8.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Sunset,
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
