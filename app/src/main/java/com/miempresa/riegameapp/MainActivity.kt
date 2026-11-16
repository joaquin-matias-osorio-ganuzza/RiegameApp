package com.miempresa.riegameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.miempresa.riegameapp.ui.AppRoot
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme



@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            RiegameAppTheme {

                AppRoot()

               }
            }
        }
    }





