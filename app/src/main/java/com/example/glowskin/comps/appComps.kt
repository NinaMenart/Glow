package com.example.glowskin.comps

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HeadingText(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 45.sp,
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
            .padding(start = 16.dp, end = 16.dp, top = 186.dp, bottom = 8.dp),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 55.sp,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}




