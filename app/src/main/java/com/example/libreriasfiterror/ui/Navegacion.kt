package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libreriasfiterror.viewmodel.UsuarioViewModel

@Composable
fun NavegacionApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "registro",
        route = "app_root"
    ) {
        // Pantalla de Registro
        composable(route = "registro") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("app_root")
            }
            val usuarioViewModel: UsuarioViewModel = viewModel(parentEntry)

            RegistroScreen(
                navController = navController,  // ← Usa nombre explícito
                usuarioViewModel = usuarioViewModel  // ← Usa nombre explícito
            )
        }

        // Pantalla de Resumen
        composable(route = "resumen") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("app_root")
            }
            val usuarioViewModel: UsuarioViewModel = viewModel(parentEntry)

            ResumenScreen(
                navController = navController,  // ← Usa nombre explícito
                usuarioViewModel = usuarioViewModel  // ← Usa nombre explícito
            )
        }

        // Pantalla Home
        composable(route = "home") {
            HomeScreen()
        }
    }
}
