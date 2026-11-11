package com.miempresa.riegameapp.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme

data class TarjetaNotificacionData(
    val titulo: String,
    val subtitulo: String
)



@Composable
fun TarjetaNotificacion(data: TarjetaNotificacionData, modifier: Modifier = Modifier){

    Card(modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(width = 0.3.dp, color = MaterialTheme.colorScheme.primary)
    ) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
           Box(modifier = Modifier
               .size(48.dp)
               .clip(RoundedCornerShape(12.dp))
               .background(MaterialTheme.colorScheme.background),
               contentAlignment = Alignment.Center

           ) {
               Icon(modifier = Modifier.size(24.dp),
                   painter = painterResource(R.drawable.gota_de_agua_llena),
                   contentDescription = stringResource(R.string.gota_de_agua),
                   tint = MaterialTheme.colorScheme.primary)
           }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(data.titulo, fontWeight = FontWeight.Bold)
                Text(data.subtitulo, color = MaterialTheme.colorScheme.onSurface)
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun TarjetaNotificacionPreview(){
    RiegameAppTheme {
        Box(modifier = Modifier.padding(16.dp)) {

            val datosEjemplo = TarjetaNotificacionData(
                titulo = "2 plantas necesitan agua",
                subtitulo = "Un pequeño cuidado para tus plantas"
            )

            TarjetaNotificacion(data = datosEjemplo)
        }
    }
}