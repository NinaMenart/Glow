package com.example.glowskin.screen

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.glowskin.R
import com.example.glowskin.comps.JokeText
import com.example.glowskin.ui.theme.GlowSkinTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json




@Composable
fun ShowJoke() {
    var joke by remember { mutableStateOf<Joke?>(null) }

    LaunchedEffect(key1 = true) {
        try {
            joke = fetchJoke()
        } catch (e: Exception) {
            Log.e("USERSCREEN", "Error fetching joke", e)
        }
    }

    joke?.let {
        JokeText(it.joke)
    }

    val context: Context = LocalContext.current
    val lottieAnimationView = remember {
        LottieAnimationView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setAnimation(R.raw.smrt)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
    }

    AndroidView({ lottieAnimationView }, update = {
    })
}
@Serializable
data class Joke(val joke: String)

suspend fun fetchJoke(): Joke {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    val response: HttpResponse = client.get("https://geek-jokes.sameerkumar.website/api?format=json")
    return response.body<Joke>()
}

@Composable
@Preview(showBackground = true)
fun PreviewShowJoke() {
    GlowSkinTheme {
        ShowJoke()
    }
}
