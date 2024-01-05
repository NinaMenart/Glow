package com.example.glowskin.screen

import android.content.Context
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.glowskin.R
import com.example.glowskin.comps.WelcomeText


@Composable
fun HomeScreen() {
    Image(
        painter = painterResource(id = R.drawable.logo1),
        contentDescription = null,
        modifier = Modifier.size(90.dp)
            .padding(5.dp),
    )

    Spacer(modifier = Modifier.height(16.dp))
    WelcomeText(value = "Pozdravljeni")
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

    AndroidView({ lottieAnimationView }, update = {
    })
}



