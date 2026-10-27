package com.miempresa.riegameapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.miempresa.riegameapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onAddPlant: () -> Unit = {},
    onOpenSettings: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(stringResource(R.string.home_title))},
                actions = {
                   IconButton(onClick = onOpenSettings) {
                       Icon(
                           painter = painterResource(id = R.drawable.outline_settings_24),
                           contentDescription = stringResource(R.string.cd_settings)
                       )
                   }
                }
            )

        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddPlant) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_add_24),
                    contentDescription = stringResource(R.string.cd_add_plant)
                )
            }
        }
    ) {
        innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = stringResource(R.string.empty_plants_title),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.empty_plants_subtitle),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}