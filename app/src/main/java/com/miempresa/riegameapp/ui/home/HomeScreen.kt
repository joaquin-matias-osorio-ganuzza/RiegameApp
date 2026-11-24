package com.miempresa.riegameapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.components.CabeceraSeccion
import com.miempresa.riegameapp.ui.components.CabeceraSeccionData
import com.miempresa.riegameapp.ui.components.TarjetaNotificacion
import com.miempresa.riegameapp.ui.components.TarjetaNotificacionData
import com.miempresa.riegameapp.ui.components.TarjetaPlanta
import com.miempresa.riegameapp.ui.components.TarjetaPlantaData
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme

/**
 * Route (stateful): conecta el ViewModel con la pantalla.
 * Se invoca desde el NavGraph. NO se previsualiza.
 */
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onPlantClick: (String) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    HomeScreen(
        uiState = uiState,
        modifier = modifier,
        onPlantClick = onPlantClick
    )
}

/**
 * Screen (stateless): solo pinta a partir del [uiState].
 * Se previsualiza con datos mock.
 */
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
    onPlantClick: (String) -> Unit = {}
) {
    if (!uiState.tienePlantas) {
        Column(
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
            modifier = modifier.padding(horizontal = 16.dp)
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
                        contador = "${uiState.plantas.size} plantas"
                    )
                )
            }
            items(uiState.plantas) { planta ->
                TarjetaPlanta(
                    data = planta,
                    onClick = { onPlantClick(planta.nombre) },
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
        }
    }
}

// Datos mock
private val previewPlantas = listOf(
    TarjetaPlantaData(nombre = "Monstera", lugar = "Salón", fechaRiego = "Hoy", imagen = R.drawable.monstera),
    TarjetaPlantaData(nombre = "Calathea", lugar = "Dormitorio", fechaRiego = "Mañana", imagen = R.drawable.calathea),
    TarjetaPlantaData(nombre = "Pilea", lugar = "Estudio", fechaRiego = "24 may", imagen = R.drawable.pilea)
)

@Preview(showBackground = true, name = "Estado Vacío")
@Composable
fun HomeScreenPreview() {
    RiegameAppTheme {
        HomeScreen(uiState = HomeUiState())
    }
}

@Preview(showBackground = true, name = "Con Plantas")
@Composable
fun HomeScreenPreviewLleno() {
    RiegameAppTheme {
        HomeScreen(uiState = HomeUiState(plantas = previewPlantas))
    }
}