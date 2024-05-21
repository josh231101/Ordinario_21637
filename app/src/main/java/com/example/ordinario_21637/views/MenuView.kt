package com.example.ordinario_21637.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ordinario_21637.components.CardMenu
import com.example.ordinario_21637.viewmodels.CardsMenuViewModel


@Composable
fun MenuView(navController: NavHostController) {
    val Cards = CardsMenuViewModel()
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(15.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn {
            items(Cards.getCardsMenu()){
                card ->
                    CardMenu(card, color = Color(0xFFF2F2F2), navController)
                    Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}