package com.miempresa.riegameapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.miempresa.riegameapp.ui.createplant.PaginaNuevaPlanta
import com.miempresa.riegameapp.ui.detail.PaginaDetallePlanta
import com.miempresa.riegameapp.ui.home.HomeRoute



@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier
    ) {
        composable<Home> {
            HomeRoute(
                onPlantClick = { nombre -> navController.navigate(DetallePlanta(nombre)) }
            )
        }
        composable<DetallePlanta> { backStackEntry ->
            val ruta = backStackEntry.toRoute<DetallePlanta>()
            PaginaDetallePlanta(
                onBackClick = { navController.popBackStack() }
            )

        }
        composable<NuevaPlanta> {
            PaginaNuevaPlanta(
                onBackClick = { navController.popBackStack() }
            )
        }

    }
}