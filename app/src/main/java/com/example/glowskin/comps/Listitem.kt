package com.example.glowskin.comps
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem (
    val route: String,
    val icon: ImageVector
)

data class ListItem(
    val title: String,
    val shortDescription: String,
    val imageID: Int
)

data class Routine(
    val title: String,
    val shortDescription: String
)
