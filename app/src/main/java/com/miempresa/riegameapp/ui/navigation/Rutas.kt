package com.miempresa.riegameapp.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
data object Home
@Serializable
data object NuevaPlanta
@Serializable
data class DetallePlanta(val nombrePlanta: String) //Si recibe parametros usamos data class

