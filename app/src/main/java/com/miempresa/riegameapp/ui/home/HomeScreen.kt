package com.miempresa.riegameapp.ui.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.components.CabeceraSeccion
import com.miempresa.riegameapp.ui.components.CabeceraSeccionData
import com.miempresa.riegameapp.ui.components.TarjetaNotificacion
import com.miempresa.riegameapp.ui.components.TarjetaNotificacionData
import com.miempresa.riegameapp.ui.components.TarjetaPlanta
import com.miempresa.riegameapp.ui.components.TarjetaPlantaData
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    hasPlants: Boolean = true
){
        if(!hasPlants){
            Column (
                modifier = modifier
                    .fillMaxSize()
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
                     modifier = modifier
                    .padding(horizontal = 16.dp),
                // Quitamos el Arrangement.Center porque la lista debe empezar arriba
            ) {
                item {
                    TarjetaNotificacion(
                        data = TarjetaNotificacionData(
                            titulo = "2 plantas necesitan agua",
                            subtitulo = "Un pequeño cuidado para hoy"
                        ),
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                    )
                }
                item {
                    CabeceraSeccion(
                        data = CabeceraSeccionData(
                            titulo = "En casa",
                                contador = "4 plantas"
                        )
                    )
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
                    TarjetaPlanta(
                        data = TarjetaPlantaData(
                            nombre = nombre,
                            lugar = lugar,
                            fechaRiego = fecha,
                            imagen = imagen
                        ),
                        modifier = Modifier.padding(bottom = 12.dp)
                    )                }
            }
          }
         }





@Preview(showBackground = true, name = "Estado Vacío")
@Composable
fun HomeScreenPreview(){
    RiegameAppTheme {
        HomeScreen(hasPlants = false)
    }
}

@Preview(showBackground = true, name = "Con Plantas")
@Composable
fun HomeScreenPreviewLleno() {
    RiegameAppTheme {
        HomeScreen(hasPlants = true)
    }
}