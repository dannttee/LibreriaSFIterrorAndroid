package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel
import com.example.libreriasfiterror.viewmodel.CartViewModel
import com.example.libreriasfiterror.viewmodel.CatalogoViewModel

@Composable
fun LibraryAppNavegacion(userAdminViewModel: UserAdminViewModel) {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()
    val catalogViewModel: CatalogoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userAdminViewModel) }
        composable("home") { HomeScreen(navController, userAdminViewModel) }
        composable("catalogo") { CatalogoScreen(navController, catalogViewModel, cartViewModel, userAdminViewModel) }
        composable("detalle") { DetalleProductoScreen(navController) }
        composable("carrito") { CarritoScreen(navController, cartViewModel) }
        composable("admin") {
            PanelAdminScreen(
                navController = navController,
                catalogViewModel = catalogViewModel,
                userAdminViewModel = userAdminViewModel
            )
        }
        composable("info") { InfoScreen(navController) }
    }
}
