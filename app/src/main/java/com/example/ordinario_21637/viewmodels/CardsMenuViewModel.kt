package com.example.ordinario_21637.viewmodels

import androidx.lifecycle.ViewModel
import com.example.ordinario_21637.R
import com.example.ordinario_21637.models.CardMenu

class CardsMenuViewModel: ViewModel() {
    init {

    }

    fun getCardsMenu(): ArrayList<CardMenu> {
        val card: CardMenu = CardMenu(1, "Adivina la edad", R.drawable.pastel, "Edad")
        val cardsMenu: ArrayList<CardMenu> = ArrayList()
        cardsMenu.add(card)
        cardsMenu.add(CardMenu(2, "Gatos", R.drawable.gato, "Gatos"))
        cardsMenu.add(CardMenu(3, "NBA", R.drawable.nba, "NBA"))
        cardsMenu.add(CardMenu(4, "Chuck Norris", R.drawable.chuck, "Chuck"))
        return cardsMenu
    }

}