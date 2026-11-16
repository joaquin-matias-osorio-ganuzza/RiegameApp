package com.miempresa.riegameapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miempresa.riegameapp.ui.components.BotonRiego
import com.miempresa.riegameapp.ui.components.BotonRiegoData
import com.miempresa.riegameapp.ui.components.CabeceraDetalle
import com.miempresa.riegameapp.ui.components.CabeceraDetalleData
import com.miempresa.riegameapp.ui.components.CabeceraHistorialRiegos
import com.miempresa.riegameapp.ui.components.HerramientasCuidado
import com.miempresa.riegameapp.ui.components.HerramientasCuidadoData
import com.miempresa.riegameapp.ui.components.ImagenDetalle
import com.miempresa.riegameapp.ui.components.ImagenDetalleData
import com.miempresa.riegameapp.ui.components.InfoPlantas
import com.miempresa.riegameapp.ui.components.InfoPlantasData
import com.miempresa.riegameapp.ui.components.ItemHistorial
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


@Composable
fun PaginaDetallePlanta(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onEditClick: () -> Unit = {},
    viewModel: DetallePlantaViewModel = viewModel()
)
{

    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    )
    {
        item {
            CabeceraDetalle(
                data = CabeceraDetalleData(uiState.nombrePlanta),
                onBackClick = onBackClick,
                onEditClick = onEditClick
            )
        }
        item { ImagenDetalle(ImagenDetalleData(uiState.imagen, "Saludable")) }
        item { InfoPlantas(InfoPlantasData(uiState.nombrePlanta, uiState.ubicacion, uiState.diasRiego)) }
        item { BotonRiego(BotonRiegoData("Hoy"), onClick = {}) }
        item { HerramientasCuidado(
            HerramientasCuidadoData("Luz ambiental", "Medir luz", "En el salón", "22° suave")
        ) }
        item {  CabeceraHistorialRiegos() }
        items(uiState.listaHistorial) { riego ->
            ItemHistorial(data = riego)
        }

    }

}


@Preview
@Composable
fun PaginaDetallePLantaPreview(){
    RiegameAppTheme() {
        Box(modifier = Modifier.padding(16.dp).background(MaterialTheme.colorScheme.background)) {
            PaginaDetallePlanta()
        }

    }

}