package com.example.glowskin.screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun JokeText(jokeText: String) {
    Text(
        text = jokeText,
        modifier = Modifier
            .padding(16.dp)
            ,
        color = Color.Black,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
    )

}


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
