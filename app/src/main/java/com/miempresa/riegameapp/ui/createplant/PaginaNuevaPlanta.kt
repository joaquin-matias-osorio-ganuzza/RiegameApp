package com.miempresa.riegameapp.ui.createplant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




@Composable
fun PaginaNuevaPlanta(
  modifier: Modifier = Modifier
)
{
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 16.dp)
               .verticalScroll(rememberScrollState()),
           verticalArrangement = Arrangement.spacedBy(16.dp)
       ) {

       }
   }









@Preview(showBackground = true)
@Composable
fun PaginaNuevaPlantaPreview() {
    PaginaNuevaPlanta()
}