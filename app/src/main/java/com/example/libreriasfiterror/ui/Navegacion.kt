package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable

@Composable
fun NavegacionApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        // Agregar más pantallas aquí mas adelante
    }
}