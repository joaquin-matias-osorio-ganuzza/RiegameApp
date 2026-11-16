package com.miempresa.riegameapp.ui.detail

import androidx.annotation.DrawableRes
import com.miempresa.riegameapp.ui.components.ItemHistorialData


/* El UI state recoge los parametros (valores) para pintarlos en la pantalla*/
data class DetallePlantaUiState(
    val nombrePlanta: String = "",
    @DrawableRes val imagen: Int = 0,
    val ubicacion: String = "",
    val diasRiego: String = "",
    val listaHistorial: List<ItemHistorialData> = emptyList()
)