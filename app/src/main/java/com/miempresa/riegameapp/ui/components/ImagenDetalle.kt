package com.miempresa.riegameapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme


data class ImagenDetalleData(
    @DrawableRes val imagen: Int,
    val estadoSalud: String
)

@Composable
fun ImagenDetalle(
    data: ImagenDetalleData,
    modifier: Modifier = Modifier
) {

    Box(
         modifier = modifier
             .fillMaxWidth()
             .height(250.dp)
             .clip(RoundedCornerShape(24.dp))
    ) {
        Image(
            painter = painterResource(id = data.imagen),
            contentDescription = stringResource(com.miempresa.riegameapp.R.string.image_plant),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd).padding(16.dp)
        )
        {
            Surface(modifier= Modifier,
                shape = RoundedCornerShape(50),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
            ){
                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier= Modifier
                        .size(8.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondary)
                    )
                    {
                    }
                    Spacer(modifier= Modifier.width(6.dp))
                    Text(data.estadoSalud, color = MaterialTheme.colorScheme.onPrimary,style = MaterialTheme.typography.labelSmall)

                }
            }
        }

    }

}



@Preview(showBackground = true, name = "Imagen Detalle Preview")
@Composable
fun ImagenDetallePreview() {
    RiegameAppTheme {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background) // Fondo crema para ver el contraste
        ) {
            val datosEjemplo = ImagenDetalleData(
                imagen = com.miempresa.riegameapp.R.drawable.monstera,
                estadoSalud = "Saludable"
            )

            ImagenDetalle(data = datosEjemplo)
        }
    }
}