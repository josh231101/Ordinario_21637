package com.example.ordinario_21637.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ordinario_21637.models.Quote
import com.example.ordinario_21637.network.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.logging.Logger

class QuoteViewModel: ViewModel() {
    //Inicializamos el quote a buscar como vacío
    private val _quote = MutableStateFlow<Quote?>(null)
    var quote = _quote.asStateFlow()

    init {
        //Cuando se inicialice el ViewModel, llamamos a la función para obtener los posts
        fetchRandomQuote()
    }

    fun fetchRandomQuote() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = API().getRandomJoke()
                // Imprimir la respuesta en el logger
                Log.d("API_PRUEBA ", "status es " + response.id)
                Log.d("API_PRUEBA ", "status es " + response.value)
                if(response.id != null) {
                    _quote.value = Quote(response.id, response.value, response.created_at)
                    quote = _quote
                }
                else {
                    Log.d("API_PRUEBA ", "status es null")
                    _quote.value =  Quote("0000", "NO HUBO RESPUESTA", "2023-01-01")
                    quote = _quote
                }
            }
        }
    }

}