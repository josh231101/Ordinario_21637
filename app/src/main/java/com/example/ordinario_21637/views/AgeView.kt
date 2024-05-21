package com.example.ordinario_21637.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ordinario_21637.R

@Composable
fun AgeView(navController: NavHostController) {
    var edad: String by remember {
        mutableStateOf("")
    }
    var edadReal: Int by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier,horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {
            Button(modifier= Modifier.align(Alignment.End),onClick = { navController.navigate("Menu") }) {
                Image(modifier= Modifier.size(20.dp),painter = painterResource(id = R.drawable.regresar), contentDescription = "Back")
            }
        }
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Ingresa tu año de nacimiento") }
            )
            Spacer(modifier = Modifier.size(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF1E94D5)),
                onClick = {
                    if (edad.toIntOrNull() == null) {
                        Toast.makeText(context, "Ingresa un año válido", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    edadReal = calcularEdadReal(edad.toInt())
                }
            ) {
                Text(text = "Calcular tu edad")
            }
        }

        // Flecha de regresar en la parte inferior izquierda
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            if(edadReal != 0) {
                // Mostrar un texto centrado vertical y horizontalmente en color morado
                Text(
                    text = "Tu edad es DE: $edadReal años",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color(0xFF6200EE)
                )
            }

        }


    }

}

fun calcularEdadReal(edadAnyo: Int): Int {
    // Calcular la edad a partir del año de nacimiento
    val currentYear = 2024
    return currentYear - edadAnyo
}

@Preview(showBackground = true)
@Composable
fun AgeViewPreview() {
    AgeView(navController = NavHostController(LocalContext.current))
}