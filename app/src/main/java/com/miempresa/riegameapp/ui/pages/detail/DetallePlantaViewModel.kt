package com.miempresa.riegameapp.ui.pages.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.components.ItemHistorialData
import com.miempresa.riegameapp.ui.navigation.DetallePlanta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetallePlantaViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    private val ruta: DetallePlanta = savedStateHandle.toRoute()

    private val _uiState = MutableStateFlow(DetallePlantaUiState())

    val uiState : StateFlow<DetallePlantaUiState> = _uiState.asStateFlow()

    init {
        cargarDatos()   //En el futuro los datos vendrán de una BD
    }

    private fun cargarDatos() {
        _uiState.value = DetallePlantaUiState(
            nombrePlanta =  ruta.nombrePlanta,
            imagen = R.drawable.monstera,
            ubicacion = "Salón",
            diasRiego = "7 días",
            listaHistorial = listOf(
                ItemHistorialData("12 sep", "Hace 7 días", "90 ml"),
                ItemHistorialData("05 sep", "Hace 14 días", "80 ml")
            )
        )
    }



}