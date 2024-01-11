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
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.glowskin.R
import com.example.glowskin.comps.ItemDescriptionText
import com.example.glowskin.comps.ItemHeadingText
import com.example.glowskin.comps.ListItem


@Composable
fun ListScreen(navController: NavHostController) {
    val item1 = ListItem(
        title = "10% Azelaic Acid Booster",
        shortDescription = "The powerful combination of azelaic acid, salicylic acid and plant extracts has multiple benefits for the skin. ",
        imageID = R.drawable.azelaicacid
    )

    val item2 = ListItem(
        title = "2% BHA Liquid Exfoliant",
        shortDescription = "This gentle, lightweight fluid quickly exfoliates dead skin cells both on the surface and deep inside pores to reveal smoother, clearer, more radiant-looking skin.",
        imageID = R.drawable.bhaliquid
    )

    val item3 = ListItem(
        title = "Phytoestrogen Elasticity Renewal Body Treatment",
        shortDescription = "A potent body treatment that improves the look of elasticity, crepey texture and signs of aging that coincide with estrogen decline.",
        imageID = R.drawable.phytoestrogen
    )

    val item4 = ListItem(
        title = "Triple Active Total Repair Serum",
        shortDescription = "This advanced anti-aging serum is clinically proven to visibly improve lines, discoloration & firmness with a potent blend of hexylresorcinol, retinoid + niacinamide.",
        imageID = R.drawable.triplerepair
    )

    val item5 = ListItem(
        title = "C15 Vitamin C Super Booster",
        shortDescription = "A high-strength serum with 15 percent pure vitamin C to visibly improve skin’s brightness, firmness, stubborn discoloration, and dull and uneven tone.",
        imageID = R.drawable.vitaminc
    )

    val item6 = ListItem(
        title = "CLINICAL 1% Retinol Treatment",
        shortDescription = "An advanced formula with high-strength, one percent retinol and skin-supportive peptides to address visible signs of aging like wrinkles, large pores, and discoloration.",
        imageID = R.drawable.retinol
    )

    val itemList = listOf(item1, item2, item3, item4, item5, item6)

    ListScreen(itemList)
}
@Composable
fun ListItemCard(item: ListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageID),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )


            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                ItemHeadingText(item.title)
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                ItemDescriptionText(item.shortDescription)
            }
        }
    }
}
