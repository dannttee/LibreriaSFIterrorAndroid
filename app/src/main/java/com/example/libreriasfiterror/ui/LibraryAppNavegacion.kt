package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel
import com.example.libreriasfiterror.ui.*

@Composable
fun LibraryAppNavegacion(userAdminViewModel: UserAdminViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userAdminViewModel) }
        composable("home") { HomeScreen(navController, userAdminViewModel) }
        composable("catalogo") { CatalogoScreen(navController) }
        composable("detalle") { DetalleProductoScreen(navController) }
        composable("carrito") { CarritoScreen(navController) }
        composable("admin") { PanelAdminScreen(navController) }
        composable("info") { InfoScreen(navController) }
    }
}

