package com.miempresa.riegameapp.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.miempresa.riegameapp.R
import com.miempresa.riegameapp.ui.components.MenuLateral
import com.miempresa.riegameapp.ui.components.MenuLateralData
import com.miempresa.riegameapp.ui.navigation.AppNavGraph
import com.miempresa.riegameapp.ui.navigation.DetallePlanta
import com.miempresa.riegameapp.ui.navigation.Home
import com.miempresa.riegameapp.ui.navigation.NuevaPlanta
import com.miempresa.riegameapp.ui.theme.colorTransparente
import kotlinx.coroutines.launch


val opcionesMenu = listOf(
    MenuLateralData("Inicio", R.drawable.home, Home),
    MenuLateralData("Nueva Planta", R.drawable.outline_add_24, NuevaPlanta),
    MenuLateralData("Ajustes", R.drawable.outline_settings_24, Home)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableIntStateOf(0) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    val isHome = currentDestination?.hasRoute<Home>() == true
    val isNuevaPlanta = currentDestination?.hasRoute<NuevaPlanta>() == true
    val isDetalle = currentDestination?.hasRoute<DetallePlanta>() == true

    ModalNavigationDrawer(
        drawerState = drawerState,
        //Usamos el componente y le pasamos la lógica de navegación
        drawerContent = {
            MenuLateral(
                opciones = opcionesMenu,
                onOpcionClick = { ruta ->
                    scope.launch { drawerState.close() }
                    navController.navigate(ruta) {
                        popUpTo<Home> { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                // Mostramos la barra solo si NO estamos en Detalle
                if (!isDetalle) {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.colorTransparente),
                        title = {
                            if (isHome) {
                                Column {
                                    Text(stringResource(R.string.app_name), color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.labelMedium)
                                    Text(stringResource(R.string.home_title), style = MaterialTheme.typography.displaySmall)
                                }
                            } else if (isNuevaPlanta) {
                                Column {
                                    Text(stringResource(R.string.app_name), color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.labelMedium)
                                    Text(stringResource(R.string.new_plant), style = MaterialTheme.typography.displaySmall)
                                }
                            }
                        },
                        navigationIcon = {
                            // EL BOTÓN DE LA HAMBURGUESA VA AQUÍ DENTRO
                            if (isHome) {
                                IconButton(onClick = {
                                    scope.launch { drawerState.open() } }) {
                                    Icon(
                                        painter = painterResource(R.drawable.menu),
                                        contentDescription = stringResource(R.string.menu),
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            } else if (isNuevaPlanta) {

                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.flecha_volver_atras),
                                        contentDescription = "Volver",
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        },
                        actions = {
                            if (isHome) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.onPrimary)
                                ) {
                                    IconButton(onClick = { /* Ajustes */ }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.outline_settings_24),
                                            contentDescription = stringResource(R.string.cd_settings),
                                            tint = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }
                    )
                }
            },
            floatingActionButton = {
                if (isHome) {
                    FloatingActionButton(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        onClick = {
                            navController.navigate(NuevaPlanta) {
                                launchSingleTop = true
                            }
                        },
                        shape = CircleShape
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_add_24),
                            contentDescription = stringResource(R.string.cd_add_plant)
                        )
                    }
                }
            },
            bottomBar = {
                if (isHome) {
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
                                Icon(
                                    painter = painterResource(id = R.drawable.home),
                                    contentDescription = stringResource(R.string.home),
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            AppNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}