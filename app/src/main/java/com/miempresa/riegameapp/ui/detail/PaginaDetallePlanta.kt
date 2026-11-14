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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
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
import com.miempresa.riegameapp.ui.components.ItemHistorialData
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


@Composable
fun PaginaDetallePlanta() {

    val datosCabecera = CabeceraDetalleData("Monstera")
    val datosImagen = ImagenDetalleData(R.drawable.monstera, "Saludable")
    val datosInfo = InfoPlantasData("Monstera", "Salón", "7 días")
    val datosRiego = BotonRiegoData("Hoy")
    val datosHerramientas = HerramientasCuidadoData("Luz ambiental", "Medir luz", "En el salón", "22° suave")
    val listaHistorial = listOf(ItemHistorialData("12 sep", "Hace 7 días", "90 ml"), ItemHistorialData("05 sep", "Hace 14 días", "80 ml"))




    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    )
    {
        item { CabeceraDetalle(datosCabecera, onBackClick = {},onEditClick = {}) }
        item { ImagenDetalle(datosImagen) }
        item { InfoPlantas(datosInfo) }
        item { BotonRiego(datosRiego, onClick = {}) }
        item { HerramientasCuidado(datosHerramientas) }
        item { CabeceraHistorialRiegos() }
        items(listaHistorial) { riego ->
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