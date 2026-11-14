package com.miempresa.riegameapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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


data class CabeceraDetalleData(
    val titulo: String
)

@Composable
fun CabeceraDetalle(
    data: CabeceraDetalleData,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
)
{
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
           Box(
               modifier = Modifier
                   .size(40.dp)
                   .clip(RoundedCornerShape(12.dp))
                   .background(MaterialTheme.colorScheme.onPrimary),
               contentAlignment = Alignment.Center
           )
           {
               Icon(
                   painter = painterResource(R.drawable.flecha_volver_atras),
                   contentDescription = stringResource(R.string.arrow_left),
                   tint = MaterialTheme.colorScheme.onSurface
               )
           }
        Text(stringResource(R.string.title_edit_your_plant),style = MaterialTheme.typography.titleLarge,fontWeight = FontWeight.Bold)

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.onPrimary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.lapiz),
                contentDescription = stringResource(R.string.arrow_left),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun CabeceraDetallePreview() {
    RiegameAppTheme {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            CabeceraDetalle(
                data = CabeceraDetalleData(titulo = "Monstera"),
                onBackClick = {},
                onEditClick = {}
            )
        }
    }
}