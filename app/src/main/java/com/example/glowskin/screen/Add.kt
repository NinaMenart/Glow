package com.example.glowskin.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.glowskin.R
import com.example.glowskin.comps.ListItem

@Composable
fun AddScreen(
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
            text = "Add Item",
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
            label = { Text("Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = shortDescription,
            onValueChange = { shortDescription = it },
            label = { Text("Short Description") },
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
                imageID = painterResource(id = R.drawable.logo1)
            )

            // Call the callback function to add the item to the list
            onItemAdded(newItem)

            // Navigate back to the list screen
            navController.popBackStack()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Dodaj v rutino")
    }
}
