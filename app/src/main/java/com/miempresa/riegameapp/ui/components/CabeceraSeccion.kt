package com.miempresa.riegameapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp



@Composable
fun CabeceraSeccion(titulo: String, contador: String, modifier : Modifier = Modifier){

    Row(
        modifier.fillMaxWidth()
        .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
       )
    {
        Text(titulo, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f)) //Empuja el siguiente texto al margen derecho
        Text(contador, color = Color.Gray)
    }


}




@Preview
@Composable
fun CabeceraSeccionPreview(){
    CabeceraSeccion("En casa","4 plantas")
}