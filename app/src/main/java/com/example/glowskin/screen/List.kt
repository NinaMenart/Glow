package com.example.glowskin.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.glowskin.R
import com.example.glowskin.comps.ListItem


@Composable
fun ListScreen(navController: NavHostController) {
    val item1 = ListItem(
        title = "Ime 1",
        shortDescription = "Short description for Item 1",
        imageID = R.drawable.logo1
    )

    val item2 = ListItem(
        title = "Ime 2",
        shortDescription = "Short description for Item 2",
        imageID = R.drawable.logo1
    )

    val item3 = ListItem(
        title = "Ime 3",
        shortDescription = "Short description for Item 3",
        imageID = R.drawable.logo1
    )

    val itemList = listOf(item1, item2, item3)

    ListScreen(itemList)
}
@Composable
fun ListItemCard(item: ListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageID),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )


            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = item.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.shortDescription)
            }
        }
    }
}
