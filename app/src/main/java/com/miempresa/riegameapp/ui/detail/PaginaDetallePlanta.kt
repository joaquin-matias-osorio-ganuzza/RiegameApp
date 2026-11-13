package com.miempresa.riegameapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


@Composable
fun PaginaDetallePlanta() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    )
    {
        item { Text("Cabecera") }
        item { Text("Imagen planta") }
        item {Text("Nobre de la planta") }
        item { Text("Dos tarjetas") }
        item { Text("Boton regar") }
        item { Text("Tarjetas de medicion") }
        item { Text("Texto de historial") }
        item { Text("Cards de historial") }

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