package com.miempresa.riegameapp

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
import com.miempresa.riegameapp.ui.components.TarjetaNotificacion
import com.miempresa.riegameapp.ui.home.HomeScreen
import com.miempresa.riegameapp.ui.home.HomeScreenPreviewLleno
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RiegameAppTheme {
                TarjetaNotificacion("2 plantas necesitan agua","Un pequeño cuidado para tus plantas")
            }
            }
        }
    }


