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
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


data class ItemHistorialData(
    val fechaRiego: String,
    val ultimoRiego: String,
    val cantidadAgua: String
)


@Composable
fun ItemHistorial(
    data: ItemHistorialData,
    modifier: Modifier = Modifier
)
{

        Card(modifier = modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(12.dp)
        )
        {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.padding(12.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(10.dp))
                        .size(40.dp),
                    contentAlignment = Alignment.Center

                )
                {
                    Icon(painter = painterResource(R.drawable.gota_de_agua_llena),
                        contentDescription = stringResource(R.string.drop_of_water),
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(15.dp)
                    )
                }
                Column()
                {
                    Text(data.fechaRiego, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSecondary)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(data.ultimoRiego, style = MaterialTheme.typography.labelSmall)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column()
                {
                    Text(data.cantidadAgua,style = MaterialTheme.typography.labelSmall)
                }
            }

        }

}


@Preview(showBackground = true)
@Composable
fun ItemHistorialPreview() {

    RiegameAppTheme() {
        Box(modifier = Modifier.padding(16.dp)) {

            val datos = ItemHistorialData(
                fechaRiego = "12 de sep",
                ultimoRiego = "Hace 7 días",
                cantidadAgua = "90 ml"
            )

            ItemHistorial(datos)
        }

    }
}