package com.miempresa.riegameapp.ui.createplant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.ColorPrincipal


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaginaNuevaPlanta(
    onBackClick: () -> Unit = {}
)
{

   Scaffold(
       containerColor = ColorPrincipal,
       topBar = {
           TopAppBar(
               colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
               title = {
                   Column() {
                       Text(stringResource(id = R.string.app_name))
                       Text(stringResource(id = R.string.nueva_planta))
                   }
               },
               navigationIcon = {
                   Box(
                       modifier = Modifier
                           .padding(start = 8.dp)
                           .size(48.dp)
                           .clip(CircleShape)
                           .background(Color.White),
                       contentAlignment = Alignment.Center
                   ) {
                       IconButton(
                           onClick = onBackClick,
                           modifier = Modifier.fillMaxSize()
                       ) {
                           Icon(
                               painter = painterResource(id = R.drawable.flecha_volver_atras),
                               contentDescription = "Volver",
                               tint = Color.Black
                           )
                       }
                   }
               }
           )
       }
   ) { innerPadding ->
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(innerPadding)
               .padding(horizontal = 16.dp)
               .verticalScroll(rememberScrollState()),
           verticalArrangement = Arrangement.spacedBy(16.dp)
       ) {

       }
   }
}








@Preview(showBackground = true)
@Composable
fun PaginaNuevaPlantaPreview() {
    PaginaNuevaPlanta()
}