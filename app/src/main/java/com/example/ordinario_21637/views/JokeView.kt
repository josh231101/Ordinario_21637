package com.example.ordinario_21637.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ordinario_21637.R
import com.example.ordinario_21637.viewmodels.QuoteViewModel

@Composable
fun JokeView(navController: NavHostController, quoteViewModel: QuoteViewModel) {
    val quote = quoteViewModel.quote.collectAsState()
    // Poner un boton de regreso en la parte superior derecha

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp)) {
        Button(modifier= Modifier.align(Alignment.End),onClick = { navController.navigate("Menu") }) {
            Image(modifier= Modifier.size(20.dp),painter = painterResource(id = R.drawable.regresar), contentDescription = "Back")
        }
        Column(Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            if(quote.value != null) {
                Text(text = "${quote.value!!.value}")
                Spacer(modifier = Modifier.height(16.dp))
                // Id de la quote en color azul
                Row {
                    Text(text = "${quote.value!!.id}", color = Color.Blue)
                    // Fecha de creacion en color cafe
                    Text(text = "${quote.value!!.created_at}", color = Color(0xFF663300))
                }
            }
        }

    }

}