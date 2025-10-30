package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.libreriasfiterror.model.Libro
import com.example.libreriasfiterror.viewmodel.CatalogoViewModel
import com.example.libreriasfiterror.viewmodel.CartViewModel
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel

@Composable
fun CatalogoScreen(
    navController: NavController,
    catalogoViewModel: CatalogoViewModel,
    cartViewModel: CartViewModel,
    userAdminViewModel: UserAdminViewModel
) {
    val productos = catalogoViewModel.libros
    val snackbarHostState = remember { SnackbarHostState() }
    var libroAgregado by remember { mutableStateOf<Libro?>(null) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        libroAgregado?.let { libro ->
            LaunchedEffect(libro) {
                snackbarHostState.showSnackbar("Libro agregado: ${libro.nombre}")
                libroAgregado = null
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Catálogo de libros", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                items(productos) { producto ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "${producto.nombre} - \$${producto.precio}",
                            modifier = Modifier.weight(1f)
                        )
                        Button(
                            onClick = {
                                cartViewModel.addLibroAlCarrito(producto)
                                libroAgregado = producto
                            },
                            modifier = Modifier.width(100.dp)
                        ) {
                            Text("Agregar")
                        }
                    }
                }
            }

            Button(
                onClick = {
                    if (userAdminViewModel.isAdmin) {
                        navController.navigate("admin") {
                            popUpTo("catalogo") { inclusive = true }
                        }
                    } else {
                        navController.navigate("home") {
                            popUpTo("catalogo") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Volver")
            }
        }
    }
}


