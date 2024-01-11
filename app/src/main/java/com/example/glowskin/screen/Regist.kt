package com.example.glowskin.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.glowskin.R
import com.example.glowskin.comps.HeadingText
import com.example.glowskin.comps.WelcomeText
import androidx.compose.material3.Text as Text1




@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun RegisterForm(
              onRegisterConfirm: (Boolean, NavHostController) -> Unit,
              navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo3),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        WelcomeText(value = "Registracija")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text1(text = "Uporabnik") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
                .background(Color.White.copy(alpha = 0.3f)),
        )


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text1(text = "Geslo") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
                .background(Color.White.copy(alpha = 0.3f)),
        )

        OutlinedTextField(
            value = repassword,
            onValueChange = { repassword = it },
            label = { Text1(text = "Ponovi geslo") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
                .background(Color.White.copy(alpha = 0.3f)),
        )

        Button(
            onClick = {
                onRegisterConfirm(true, navController)
            },
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(8.dp)
        ) {
            Text1(text = "Potrdi registracijo")
        }
    }
}
