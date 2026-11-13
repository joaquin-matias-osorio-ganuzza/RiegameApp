package com.miempresa.riegameapp.ui.createplant

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.ui.components.BotonGuardarData
import com.miempresa.riegameapp.ui.components.BotonGuardarPlanta
import com.miempresa.riegameapp.ui.components.TarjetaDatosBasicos
import com.miempresa.riegameapp.ui.components.TarjetaDatosBasicosData
import com.miempresa.riegameapp.ui.components.TarjetaFoto
import com.miempresa.riegameapp.ui.components.TarjetaFotoData
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


@Composable
fun PaginaNuevaPlanta(
  modifier: Modifier = Modifier
)
{

    var datosBasicos by remember {
        mutableStateOf(TarjetaDatosBasicosData(nombre = "", ubicacion = "", diasRiego = "7"))
    }
    var datosFoto by remember {
        mutableStateOf(TarjetaFotoData(tieneFoto = false))
    }

       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 16.dp)
               .verticalScroll(rememberScrollState()),
           verticalArrangement = Arrangement.spacedBy(16.dp)
       ) {
           TarjetaDatosBasicos(
               data = datosBasicos,

               onNombreChange = { nuevoNombre ->
                   datosBasicos = datosBasicos.copy(nombre = nuevoNombre)
               },
               onUbicacionChange = { nuevaUbicacion ->
                   datosBasicos = datosBasicos.copy(ubicacion = nuevaUbicacion)
               },
               onDiasChange = { nuevosDias ->
                   datosBasicos = datosBasicos.copy(diasRiego = nuevosDias)
               }
           )

           TarjetaFoto(
               data = datosFoto,
               onAddPhotoClick = {
                   datosFoto = datosFoto.copy(tieneFoto = true)
               }
           )

           BotonGuardarPlanta(
               data = BotonGuardarData(texto = "Guardar planta"),
               onClick = {}
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