package com.miempresa.riegameapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.ColorBotonRegarPlanta
import com.miempresa.riegameapp.ui.theme.ColorNotificacion



data class TarjetaPlantaData(
    val nombre: String,
    val lugar: String,
    val fechaRiego: String,
    @DrawableRes val imagen: Int

)

@Composable
fun TarjetaPlanta(
    data: TarjetaPlantaData,
    modifier: Modifier = Modifier

) {

    Card(modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        border = BorderStroke(0.4.dp, color = MaterialTheme.colorScheme.onSurface)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Box(
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(12.dp))

            ) {
                Image(
                    painter = painterResource(id = data.imagen),
                    contentDescription = "Foto $data.nombre",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp)) //Importante el orden para dar estilo, si movemos clip a otra posicion, no podemos ver el efecto redondeado o de capsula
                        .background(Color.Black.copy(alpha = 0.6f))
                        .padding(horizontal = 4.dp, vertical = 2.dp)

                )
                {
                    Text(data.lugar, color = MaterialTheme.colorScheme.onPrimary, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f),
                 verticalArrangement = Arrangement.spacedBy(8.dp)
                )
            {
               Text(data.nombre, style = MaterialTheme.typography.titleMedium)

                Row(modifier = Modifier.fillMaxWidth(),
                     verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(stringResource(R.string.regar), color = MaterialTheme.colorScheme.onSurface)
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(data.fechaRiego, style = MaterialTheme.typography.labelMedium)
                    Spacer(modifier = Modifier.weight(1f))

                    Box(modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(ColorNotificacion),
                        contentAlignment = Alignment.Center

                    ) {
                        Icon(modifier = Modifier.size(15.dp),
                            painter = painterResource(R.drawable.gota_de_agua_llena),
                            contentDescription = stringResource(id = R.string.gota_de_agua),
                            tint = ColorBotonRegarPlanta)
                    }
                }
            }

        }

    }


}





@Preview(showBackground = true)
@Composable
fun TarjetaPlantaPreview(){
    Box(modifier = Modifier.padding(16.dp)) {
        val datosEjemplo = TarjetaPlantaData(
            nombre = "Monstera",
            lugar = "Salon",
            fechaRiego = "24 may",
            imagen = R.drawable.monstera
        )
    TarjetaPlanta(datosEjemplo)
}
}