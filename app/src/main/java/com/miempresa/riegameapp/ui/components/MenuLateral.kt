package com.miempresa.riegameapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme

data class MenuLateralData(
    val etiqueta: String,
    @DrawableRes val icono: Int,
    val ruta: Any // Usamos Any para aceptar data objects y data classes
)


    @Composable
    fun MenuLateral(
        opciones: List<MenuLateralData>,
        onOpcionClick: (Any) -> Unit,
        modifier: Modifier = Modifier
    ) {
        ModalDrawerSheet(modifier = modifier) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.app_name),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            opciones.forEach { opcion ->
                NavigationDrawerItem(
                    label = { Text(opcion.etiqueta, color = MaterialTheme.colorScheme.onSurface) },
                    icon = {
                        Icon(
                            painter = painterResource(id = opcion.icono),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    selected = false,
                    onClick = { onOpcionClick(opcion.ruta) }
                )
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun MenuLateralPreview(){

    RiegameAppTheme() {

        val opcionesEjemplo = listOf(
            MenuLateralData(stringResource(R.string.home_menu), R.drawable.home, "home"),
            MenuLateralData(stringResource(R.string.new_plant), R.drawable.outline_add_24, "nueva"),
            MenuLateralData(stringResource(R.string.cd_settings), R.drawable.outline_settings_24, "ajustes")
        )

        MenuLateral(
            opciones = opcionesEjemplo,
            onOpcionClick = { ruta ->  }
        )
    }

}


