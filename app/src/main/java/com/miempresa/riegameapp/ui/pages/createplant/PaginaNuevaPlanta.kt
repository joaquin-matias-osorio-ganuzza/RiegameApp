package com.miempresa.riegameapp.ui.pages.createplant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miempresa.riegameapp.ui.components.BotonGuardarData
import com.miempresa.riegameapp.ui.components.BotonGuardarPlanta
import com.miempresa.riegameapp.ui.components.TarjetaDatosBasicos
import com.miempresa.riegameapp.ui.components.TarjetaDatosBasicosData
import com.miempresa.riegameapp.ui.components.TarjetaFoto
import com.miempresa.riegameapp.ui.components.TarjetaFotoData
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


@Composable
fun PaginaNuevaPlanta(
  modifier: Modifier = Modifier,
  onBackClick: () -> Unit = {},
  viewModel: NuevaPlantaViewModel = viewModel()
)
{
    val uiState by viewModel.uiState.collectAsState()

       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 16.dp)
               .verticalScroll(rememberScrollState()),
           verticalArrangement = Arrangement.spacedBy(16.dp)
       ) {
           TarjetaDatosBasicos(
               data = TarjetaDatosBasicosData(
                   nombre = uiState.nombre,
                   ubicacion = uiState.ubicacion,
                   diasRiego = uiState.diasRiego
               ),
               onNombreChange = viewModel::onNombreChange,
               onUbicacionChange = viewModel::onUbicacionChange,
               onDiasChange = viewModel::onDiasChange
           )
           TarjetaFoto(
               data = TarjetaFotoData(tieneFoto = uiState.tieneFoto),
               onAddPhotoClick = viewModel::onAddPhotoClick
           )

           BotonGuardarPlanta(
               data = BotonGuardarData(texto = "Guardar planta"),
               onClick = {
                   viewModel.onGuardarClick()
                   onBackClick()
               }
           )
           Box(modifier = Modifier.height(24.dp))
       }
   }


@Preview(showBackground = true)
@Composable
fun PaginaNuevaPlantaPreview() {
    RiegameAppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            PaginaNuevaPlanta()
        }
    }
}