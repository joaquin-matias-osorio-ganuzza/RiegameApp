package com.miempresa.riegameapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.components.CabeceraSeccion
import com.miempresa.riegameapp.ui.components.TarjetaNotificacion
import com.miempresa.riegameapp.ui.components.TarjetaPlanta
import com.miempresa.riegameapp.ui.theme.ColorBotonFABAgregarPlanta
import com.miempresa.riegameapp.ui.theme.ColorPricipal


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    hasPlants: Boolean = true,
    onAddPlant: () -> Unit = {},
    onOpenSettings: () -> Unit = {}
){
    val monstera = R.drawable.monstera
    val calathea = R.drawable.calathea
    val pilea = R.drawable.pilea

    Scaffold(
        containerColor = ColorPricipal,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                title = {
                    Column() {
                        Text(stringResource(R.string.app_name), color = Color.Gray, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text(stringResource(R.string.home_title), fontWeight = FontWeight.Bold, fontSize = 38.sp)
                    }
                },
                actions = {
                    Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(Color.White)) {
                        IconButton(onClick = onOpenSettings) {
                            Icon(
                                painter = painterResource(id = R.drawable.outline_settings_24),
                                contentDescription = stringResource(R.string.cd_settings),

                            )
                        }
                    }

                }

            )

        },
        floatingActionButton = {
            FloatingActionButton(containerColor = ColorBotonFABAgregarPlanta, onClick = onAddPlant, shape = CircleShape) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_add_24),
                    contentDescription = stringResource(R.string.cd_add_plant)
                )
            }
        }
    ) {
        innerpadding ->

        if(!hasPlants){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerpadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                        text = stringResource(R.string.empty_plants_title),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = stringResource(R.string.empty_plants_subtitle),
                        style = MaterialTheme.typography.bodyMedium
                    )

            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(innerpadding)
                    .padding(horizontal = 16.dp),
                // Quitamos el Arrangement.Center porque la lista debe empezar arriba
            ) {
                item {
                    TarjetaNotificacion("2 plantas necesitan agua","Un pequeño cuidado para tus plantas", modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
                }
                item {
                    CabeceraSeccion("En casa","4 plantas")
                }
                items(3) {  index ->
                    val nombre = when(index) {
                        0 -> "Monstera"
                        1 -> "Calathea"
                        else -> "Pilea"
                    }
                    val lugar = when(index) {
                        0 -> "Salón"
                        1 -> "Dormitorio"
                        else -> "Estudio"
                    }
                    val fecha = when(index) {
                        0 -> "Hoy"
                        1 -> "Mañana"
                        else -> "24 may"
                    }

                    val imagen = when(index) {
                        0 -> R.drawable.monstera
                        1 -> R.drawable.calathea
                        else -> R.drawable.pilea
                    }
                    TarjetaPlanta(nombre,lugar,fecha, imagen,modifier = Modifier.padding(bottom = 12.dp))
                }
            }
          }
         }
        }




@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(hasPlants = false)
}

@Preview(showBackground = true, name = "Con Plantas")
@Composable
fun HomeScreenPreviewLleno() {
    HomeScreen(hasPlants = true)
}
