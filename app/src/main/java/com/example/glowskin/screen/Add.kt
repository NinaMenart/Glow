package com.example.glowskin.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.glowskin.R
import com.example.glowskin.comps.ListItem


@Composable
fun AddedScreen(
    navController: NavHostController,
    onItemAdded: (ListItem) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var shortDescription by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Dodaj",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input fields for the form
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Ime") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = shortDescription,
            onValueChange = { shortDescription = it },
            label = { Text("Opis") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AddItemButton(
            title = title,
            shortDescription = shortDescription,
            onItemAdded = onItemAdded,
            navController = navController
        )


    }
}

@Composable
fun AddItemButton(
    title: String,
    shortDescription: String,
    onItemAdded: (ListItem) -> Unit,
    navController: NavHostController
) {
    Button(
        onClick = {
            val newItem = ListItem(
                title = title,
                shortDescription = shortDescription,
                imageID = R.drawable.logo1
            )

            onItemAdded(newItem)

            navController.popBackStack()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Dodaj v rutino")
    }
}
