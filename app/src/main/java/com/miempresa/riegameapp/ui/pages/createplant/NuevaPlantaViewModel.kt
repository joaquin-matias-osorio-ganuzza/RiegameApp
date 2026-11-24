package com.miempresa.riegameapp.ui.pages.createplant

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NuevaPlantaViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(NuevaPlantaUiState())

    val uiState : StateFlow<NuevaPlantaUiState> = _uiState.asStateFlow()


    fun onNombreChange(nombre: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(nombre = nombre) }
    }

    fun onUbicacionChange(ubicacion: String) {
        _uiState.update { it.copy(ubicacion = ubicacion) }
    }

    fun onDiasChange(dias: String) {
        _uiState.update { it.copy(diasRiego = dias) }
    }

    fun onAddPhotoClick() {
        // Simulamos que se añade una foto
        _uiState.update { it.copy(tieneFoto = !it.tieneFoto) }
    }

    fun onGuardarClick() {

        println("Guardando planta: ${_uiState.value.nombre}")
    }


}