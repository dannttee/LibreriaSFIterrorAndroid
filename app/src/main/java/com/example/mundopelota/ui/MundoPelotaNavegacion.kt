package com.example.mundopelota.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.mundopelota.viewmodel.UserAdminViewModel
import com.example.mundopelota.viewmodel.CartViewModel
import com.example.mundopelota.viewmodel.CatalogoViewModel

@Composable
fun MundoPelotaNavegacion(userAdminViewModel: UserAdminViewModel) {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()
    val catalogoViewModel: CatalogoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userAdminViewModel) }
        composable("home") { HomeScreen(navController, userAdminViewModel) }
        composable("catalogo") {
            CatalogoScreen(
                navController = navController,
                catalogoViewModel = catalogoViewModel,
                onAgregarAlCarrito = { pelota -> cartViewModel.addPelotaAlCarrito(pelota) },
                userAdminViewModel = userAdminViewModel
            )
        }
        composable("detalle") { DetalleProductoScreen(navController) }
        composable("carrito") { CarritoScreen(navController, cartViewModel) }
        composable("admin") {
            HomeAdminScreen(
                navController = navController,
                catalogViewModel = catalogoViewModel
            )
        }
        composable(
            route = "catalogoAdmin?agregar={agregar}",
            arguments = listOf(navArgument("agregar") { type = NavType.StringType; defaultValue = "0" })
        ) {
            CatalogoAdminScreen(
                navController = navController,
                catalogViewModel = catalogoViewModel
            )
        }
        composable("catalogoAdmin") {
            CatalogoAdminScreen(
                navController = navController,
                catalogViewModel = catalogoViewModel
            )
        }
        composable("info") { InfoScreen(navController) }
    }
}









