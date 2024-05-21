package com.example.ordinario_21637.components

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ordinario_21637.models.CardMenu
import com.example.ordinario_21637.viewmodels.CardsMenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMenu(cardMenu: CardMenu, color: Color, navHostController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        onClick = {
            navHostController.navigate(cardMenu.route)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "${cardMenu.number}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(20.dp))

            Column(modifier = Modifier.padding(4.dp)) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = cardMenu.icon),
                    contentScale = ContentScale.Crop,
                    contentDescription = "CardMenu picture",
                )
                Text(text = cardMenu.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewCard() {
    CardMenu(cardMenu = CardsMenuViewModel().getCardsMenu().random(), color = Color(0xFFF2F2F2), navHostController = rememberNavController() )
}