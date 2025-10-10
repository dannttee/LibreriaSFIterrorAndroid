package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "registro") {
        composable("registro") { RegistroScreen(navController) }
        composable("resumen") { ResumenScreen() }
        composable("home") { HomeScreen() }
    }
}
