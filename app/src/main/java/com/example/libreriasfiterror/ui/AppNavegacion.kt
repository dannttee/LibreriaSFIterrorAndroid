package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        route = "app_root"
    ) {
        composable(route = "login") {
            LoginScreen(navController = navController)
        }
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "catalogo") {
            CatalogoScreen(navController = navController)
        }
        composable(route = "detalle") {
            DetalleProductoScreen(navController = navController)
        }
        composable(route = "carrito") {
            CarritoScreen(navController = navController)
        }
        composable(route = "admin") {
            PanelAdminScreen(navController = navController) // <----- CORREGIDO
        }
        composable(route = "info") {
            InfoScreen(navController = navController)
        }
    }
}
