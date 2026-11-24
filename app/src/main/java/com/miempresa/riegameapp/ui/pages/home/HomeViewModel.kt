package com.miempresa.riegameapp.ui.pages.home

import androidx.lifecycle.ViewModel
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.components.TarjetaPlantaData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState : StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        cargarPlantas()
    }


    private fun cargarPlantas() {
        val plantas = listOf(
            TarjetaPlantaData(
                nombre = "Monstera",
                lugar = "Salón",
                fechaRiego = "Hoy",
                imagen = R.drawable.monstera

            ),
            TarjetaPlantaData(
                nombre = "Calathea",
                lugar = "Dormitorio",
                fechaRiego = "Mañana",
                imagen = R.drawable.calathea

            ),
            TarjetaPlantaData(
                nombre = "Pilea",
                lugar = "Estudio",
                fechaRiego = "24 may",
                imagen = R.drawable.pilea

            )
        )
        _uiState.value = HomeUiState(plantas = plantas)
    }

}