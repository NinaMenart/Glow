package com.example.glowskin.comps

import androidx.compose.ui.graphics.painter.Painter

data class ListItem(
    val title: String,
    val shortDescription: String,
    val imageID: Painter
)
