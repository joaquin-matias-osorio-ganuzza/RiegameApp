package com.miempresa.riegameapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme



data class HerramientasCuidadoData(
    val etiquetaLuz: String,
    val valorLuz: String,
    val etiquetaClima: String,
    val valorClima: String
)


@Composable
fun HerramientasCuidado(
   data: HerramientasCuidadoData,
   modifier: Modifier = Modifier
)
{
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        )
        {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Box(
                    modifier = Modifier.padding(10.dp)
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(6.dp)),
                     contentAlignment = Alignment.Center

                )
                {
                    Icon(painter = painterResource(R.drawable.sol),
                        contentDescription = stringResource(R.string.sun),
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Column(modifier = Modifier.padding(5.dp))
                {

                    Text(data.etiquetaLuz, style = MaterialTheme.typography.labelSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(data.valorLuz, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSecondary)
                }
            }

        }

        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
        )
        {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Box(
                    modifier = Modifier.padding(10.dp)
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(6.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Icon(painter = painterResource(R.drawable.nube),
                        contentDescription = stringResource(R.string.cloud),
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Column(modifier = Modifier.padding(5.dp))
                {
                    Text(data.etiquetaClima, style = MaterialTheme.typography.labelSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(data.valorClima, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSecondary)
                }
            }

        }

    }

}










@Preview(showBackground = true)
@Composable
fun HerramientasCuidadoPreview() {

    RiegameAppTheme() {
        val datos = HerramientasCuidadoData(
            etiquetaLuz = "Luz ambiental",
            valorLuz = "Medir luz",
            etiquetaClima = "En el salón",
            valorClima = "22º suave"
        )
         Box(modifier = Modifier.padding(16.dp)) {
             HerramientasCuidado(datos)
         }
    }

}