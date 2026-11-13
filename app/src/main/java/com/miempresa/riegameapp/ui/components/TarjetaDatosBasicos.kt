package com.miempresa.riegameapp.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


data class TarjetaDatosBasicosData(
    val nombre : String,
    val ubicacion: String,
    val diasRiego: String
)



@Composable
fun TarjetaDatosBasicos(
      data: TarjetaDatosBasicosData,
      onNombreChange: (String) -> Unit,
      onUbicacionChange: (String) -> Unit,
      onDiasChange: (String) -> Unit,
      modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
    )
    {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 13.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.box_01),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface

                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column {
                    Text(
                        text = stringResource(R.string.basic_data),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(R.string.about_your_plant),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column() {
                Text(stringResource(R.string.name), style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = data.nombre,
                    shape = RoundedCornerShape(12.dp),
                    onValueChange = { onNombreChange(it)},
                   // placeholder = {Text(stringResource(R.string.name))},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                        unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,

                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,

                        focusedBorderColor = MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,

                        cursorColor = MaterialTheme.colorScheme.primary
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(stringResource(R.string.location), style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = data.ubicacion,
                    shape = RoundedCornerShape(12.dp),
                    onValueChange = {  onNombreChange(it) },
                   // placeholder = {Text(stringResource(R.string.location))},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                        unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,

                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,

                        focusedBorderColor = MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,

                        cursorColor = MaterialTheme.colorScheme.primary
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(stringResource(R.string.drop_water_at_regular), style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = data.diasRiego,
                    onValueChange = onDiasChange,
                    modifier = Modifier.width(150.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                        unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,

                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,

                        focusedBorderColor = MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,

                        cursorColor = MaterialTheme.colorScheme.primary
                    ),
                    trailingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .background(MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(6.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                    IconButton(
                                        onClick = {
                                            val actual = data.diasRiego.toIntOrNull() ?: 0
                                            onDiasChange((actual + 1).toString())
                                        },
                                        modifier = Modifier.size(16.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.flecha_arriba),
                                            contentDescription = stringResource(R.string.increment_days),
                                            modifier = Modifier.size(14.dp),
                                            tint = MaterialTheme.colorScheme.onSurface

                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            val actual = data.diasRiego.toIntOrNull() ?: 1
                                            if (actual > 1) {
                                                onDiasChange((actual - 1).toString())
                                            }
                                        },
                                        modifier = Modifier.size(16.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.flecha_abajo),
                                            contentDescription =  stringResource(R.string.decrement_days),
                                            modifier = Modifier.size(14.dp),
                                            tint = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(stringResource(R.string.days), color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                )

            }

        }

    }


}



@Preview(showBackground = true)
@Composable
fun TarjetaDatosBasicosPreview() {
    // Envolvemos en el tema para ver colores personalizados
    RiegameAppTheme {

        Box(modifier = Modifier.padding(16.dp).background(MaterialTheme.colorScheme.background)) {

            val datosEjemplo = TarjetaDatosBasicosData(
                nombre = "Monstera",
                ubicacion = "Salón",
                diasRiego = "7"
            )

            TarjetaDatosBasicos(
                data = datosEjemplo,
                onNombreChange = {},
                onUbicacionChange = {},
                onDiasChange = {}
            )
        }
    }
}




