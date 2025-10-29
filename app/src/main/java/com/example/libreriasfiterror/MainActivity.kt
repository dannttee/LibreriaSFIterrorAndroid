package com.example.libreriasfiterror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.libreriasfiterror.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usa tu tema si tienes, aquí el MaterialTheme por defecto
            MaterialTheme {
                LibraryAppNavigation()
            }
        }
    }
}

@Composable
fun LibraryAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("catalogo") { CatalogoScreen(navController) }
        composable("detalle") { DetalleProductoScreen(navController) }
        composable("carrito") { CarritoScreen(navController) }
        composable("admin") { PanelAdminScreen(navController) }
        composable("info") { InfoScreen(navController) }
    }
}
