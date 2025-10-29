package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libreriasfiterror.viewmodel.UsuarioViewModel
import com.example.libreriasfiterror.viewmodel.LibroViewModel
import com.example.libreriasfiterror.ui.catalog.CatalogoScreen
import com.example.libreriasfiterror.ui.cart.CarritoScreen
import com.example.libreriasfiterror.ui.RegistroScreen
import com.example.libreriasfiterror.ui.ResumenScreen
import com.example.libreriasfiterror.ui.HomeScreen

@Composable
fun NavegacionApp() {
    val navController = rememberNavController()
    val libroViewModel: LibroViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "registro",
        route = "app_root"
    ) {
        composable(route = "registro") { backStackEntry ->
            val usuarioViewModel: UsuarioViewModel = viewModel(backStackEntry)
            RegistroScreen(
                navController = navController,
                usuarioViewModel = usuarioViewModel
            )
        }

        composable(route = "resumen") { backStackEntry ->
            val usuarioViewModel: UsuarioViewModel = viewModel(backStackEntry)
            ResumenScreen(
                navController = navController,
                usuarioViewModel = usuarioViewModel
            )
        }

        composable(route = "home") {
            HomeScreen()
        }

        composable(route = "catalogo") {
            CatalogoScreen(
                viewModel = libroViewModel,
                onAgregarAlCarrito = { libroViewModel.agregarAlCarrito(it) },
                onIrAlCarrito = { navController.navigate("carrito") }
            )
        }

        composable(route = "carrito") {
            CarritoScreen(
                viewModel = libroViewModel,
                onEliminarDelCarrito = { libroViewModel.eliminarDelCarrito(it) },
                onVolver = { navController.popBackStack() }
            )
        }
    }
}
