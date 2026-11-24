package com.miempresa.riegameapp.ui.home

import com.miempresa.riegameapp.ui.components.TarjetaPlantaData

/**
 * Estado de la pantalla de inicio (listado de plantas).
 *
 * Contiene los datos crudos que la UI necesita para dibujarse.
 * Las propiedades derivadas (como [tienePlantas]) se calculan con `get()`
 * para evitar duplicar estado y posibles desincronizaciones.
 */
data class HomeUiState(
    val plantas: List<TarjetaPlantaData> = emptyList()
) {
    /** True si la lista tiene al menos un elemento. La UI lo usa para mostrar
     *  la lista o el empty state. */
    val tienePlantas: Boolean
        get() = plantas.isNotEmpty()
}