package com.miempresa.riegameapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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



data class BotonRiegoData(
    val textoPrincipal: String,
    val textoEstado: String
)

@Composable
fun BotonRiego(
    data: BotonRiegoData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
)
{

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary)

    )
    {
        Row(
         horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(painter = painterResource(R.drawable.gota_de_agua_llena),
                contentDescription = stringResource(R.string.drop_of_water)
                )
            Spacer(modifier = Modifier.width(10.dp))

            Text(data.textoPrincipal, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.weight(1f)) //Empuja el siguiente elemento hacia la esquina

            Box(modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f))

            )
            {
                Text(data.textoEstado, style = MaterialTheme.typography.labelSmall,modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
            }


        }

    }

}








@Preview(showBackground = true)
@Composable
fun BotonRiegoPreview() {
    RiegameAppTheme() {

        val datos = BotonRiegoData(
            textoPrincipal = "Marcar como regada",
            textoEstado = "Hoy"
        )
        Box(modifier = Modifier.padding(16.dp)) {
            BotonRiego(datos,{})
        }

    }
}