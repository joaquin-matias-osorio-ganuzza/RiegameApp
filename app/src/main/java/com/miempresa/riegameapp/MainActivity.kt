package com.miempresa.riegameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.ui.home.HomeScreen
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme
import com.miempresa.riegameapp.ui.theme.colorTransparente

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            RiegameAppTheme {

                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.colorTransparente),
                            title = {
                                Column() {
                                    Text(stringResource(R.string.app_name), color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.labelMedium)
                                    Text(stringResource(R.string.home_title), style = MaterialTheme.typography.displaySmall)
                                }
                            },
                            actions = {
                                Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(
                                    MaterialTheme.colorScheme.onPrimary)) {
                                    IconButton(onClick ={}) { //Ajustar
                                        Icon(
                                            painter = painterResource(id = R.drawable.outline_settings_24),
                                            contentDescription = stringResource(R.string.cd_settings),
                                            tint = MaterialTheme.colorScheme.onSurface

                                            )
                                    }
                                }

                            }

                        )

                    },
                    floatingActionButton = {
                        FloatingActionButton(containerColor = MaterialTheme.colorScheme.secondary, onClick = {}, shape = CircleShape) {
                            Icon(
                                painter = painterResource(id = R.drawable.outline_add_24),
                                contentDescription = stringResource(R.string.cd_add_plant)
                            )
                        }
                    }
                ) {
                        innerPadding ->
                    // Aquí irá el NavHost

                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        hasPlants = true
                    )

                }

               }
            }
        }
    }



