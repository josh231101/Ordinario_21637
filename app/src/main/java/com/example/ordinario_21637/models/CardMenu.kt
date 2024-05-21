package com.example.ordinario_21637.models

import androidx.annotation.DrawableRes

data class CardMenu(
    val number: Int,
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
)