package com.example.glowskin.screen

import android.content.Context
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.glowskin.R
import com.example.glowskin.comps.BackgroundImage
import com.example.glowskin.comps.EmptyRoutineText
import com.example.glowskin.comps.WelcomeText


@Composable
fun HomeScreen() {
    BackgroundImage()
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo3),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        WelcomeText(value = "Pozdravljeni")
        EmptyRoutineText(value = "NinaMenart")
    val context: Context = LocalContext.current

    val lottieAnimationView = remember {
        LottieAnimationView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setAnimation(R.raw.srcek2)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
    }

    AndroidView({ lottieAnimationView }, update = {})
    }
}
