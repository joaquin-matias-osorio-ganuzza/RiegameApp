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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.ColorBotonRegarPlanta
import com.miempresa.riegameapp.ui.theme.ColorNotificacion
import com.miempresa.riegameapp.ui.theme.ColorTarjetaYFondoBotones

@Composable
fun TarjetaNotificacion(titulo: String, subtitulo: String, modifier: Modifier = Modifier){

    Card(modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = ColorNotificacion),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(width = 0.3.dp, color = ColorBotonRegarPlanta)
    ) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
           Box(modifier = Modifier
               .size(48.dp)
               .clip(RoundedCornerShape(12.dp))
               .background(ColorTarjetaYFondoBotones),
               contentAlignment = Alignment.Center

           ) {
               Icon(modifier = Modifier.size(24.dp),
                   painter = painterResource(R.drawable.gota_de_agua_llena),
                   contentDescription = "Gota de agua",
                   tint = ColorBotonRegarPlanta)
           }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(titulo, fontWeight = FontWeight.Bold)
                Text(subtitulo, color = Color.Gray)
            }

        }
    }

}


@Preview(showBackground = true, backgroundColor = 0xFFF7F9F5)
@Composable
fun TarjetaNotificacionPreview(){
    Box(modifier = Modifier.padding(16.dp)) {
        TarjetaNotificacion("2 plantas necesitan agua","Un pequeño cuidado para tus plantas")
    }
}