package com.miempresa.riegameapp.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.theme.RiegameAppTheme



@Composable
fun CabeceraHistorialRiegos(
    modifier: Modifier = Modifier
)
{
    Row(modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Column() {
            Text(stringResource(R.string.recent_care), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)

            Spacer(modifier = Modifier.height(10.dp))

            Text(stringResource(R.string.irregation_history),style = MaterialTheme.typography.titleLarge)
        }
        Spacer(modifier = Modifier.weight(1f))
        Column() {
            Text(stringResource(R.string.last_30_days),style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
        }
    }


}



@Preview(showBackground = true)
@Composable
fun CabeceraHistorialRiegosPreview() {

    RiegameAppTheme() {
        Box(modifier = Modifier.padding(16.dp)) {
            CabeceraHistorialRiegos()
        }
    }
}