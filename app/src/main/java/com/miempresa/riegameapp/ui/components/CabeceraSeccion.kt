package com.miempresa.riegameapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


data class CabeceraSeccionData(
    val titulo: String,
    val contador: String
)

@Composable
fun CabeceraSeccion(data: CabeceraSeccionData, modifier : Modifier = Modifier){

    Row(
        modifier.fillMaxWidth()
        .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
       )
    {
        Text(data.titulo, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.weight(1f)) //Empuja el siguiente texto al margen derecho
        Text(data.contador, color = MaterialTheme.colorScheme.onSurface)
    }


}




@Preview
@Composable
fun CabeceraSeccionPreview(){
    RiegameAppTheme {
        Box(modifier = Modifier.padding(16.dp)) {

            val datosEjemplo = CabeceraSeccionData(
                titulo = "En casa",
                contador = "4 plantas"
            )

            CabeceraSeccion(data = datosEjemplo)
        }
    }
}