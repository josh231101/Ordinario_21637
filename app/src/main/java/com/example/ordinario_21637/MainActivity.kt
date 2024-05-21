package com.example.ordinario_21637

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ordinario_21637.handlers.NavManager
import com.example.ordinario_21637.ui.theme.Ordinario_21637Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ordinario_21637Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Start()
                }
            }
        }
    }
}

@Composable
fun Start() {
    NavManager()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ordinario_21637Theme {
        NavManager()
    }
}