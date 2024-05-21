package com.example.ordinario_21637.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ordinario_21637.viewmodels.QuoteViewModel
import com.example.ordinario_21637.views.AgeView
import com.example.ordinario_21637.views.EmptyView
import com.example.ordinario_21637.views.JokeView
import com.example.ordinario_21637.views.MenuView

@Composable
fun NavManager() {
    val navController: NavHostController = rememberNavController()
    val quoteViewModel = QuoteViewModel()
    NavHost(navController = navController, startDestination = "Menu") {
        composable(route = "Menu") {
            MenuView(navController)
        }
        composable(route = "Edad") {
            AgeView(navController)
        }
        composable(route = "Gatos") {
            EmptyView(navController)
        }
        composable(route = "NBA") {
            EmptyView(navController)
        }
        composable(route = "Chuck") {
            JokeView(navController, quoteViewModel)
        }
    }
}