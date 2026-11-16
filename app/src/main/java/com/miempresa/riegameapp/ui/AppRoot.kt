package com.miempresa.riegameapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.navigation.AppNavGraph
import com.miempresa.riegameapp.ui.theme.colorTransparente


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot() {


    val navController = rememberNavController()

    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.colorTransparente),
                title = {
                    Column() {
                        Text(stringResource(R.string.app_name), color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.labelMedium)
                        Text(stringResource(R.string.home_title), style = MaterialTheme.typography.displaySmall)
                    }
                },
                actions = {
                    Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(
                        MaterialTheme.colorScheme.onPrimary)) {
                        IconButton(onClick ={}) { //Ajustar
                            Icon(
                                painter = painterResource(id = R.drawable.outline_settings_24),
                                contentDescription = stringResource(R.string.cd_settings),
                                tint = MaterialTheme.colorScheme.onSurface

                            )
                        }
                    }

                }

            )

        },
        floatingActionButton = {
            FloatingActionButton(containerColor = MaterialTheme.colorScheme.secondary, onClick = {}, shape = CircleShape) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_add_24),
                    contentDescription = stringResource(R.string.cd_add_plant)
                )
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                NavigationBarItem(
                    selected = (selectedTab == 0),
                    onClick = { selectedTab = 0 },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.surface,
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                    ),
                    icon = {
                        Icon(painter = painterResource(id = R.drawable.home),
                            contentDescription = stringResource(R.string.home),
                            tint = MaterialTheme.colorScheme.onSurface)
                    }

                )
            }

        }
    )
    {
        innerPadding ->
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )

    }



}