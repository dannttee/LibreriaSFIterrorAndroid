package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CatalogoScreen(navController: NavController) {
    val productos = listOf(
        "Dune",
        "1984",
        "El resplandor",
        "Soy leyenda",
        "Fahrenheit 451"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Catálogo", style = MaterialTheme.typography.headlineMedium)
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
                    Text(producto, modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* acción agregar */ },
                        modifier = Modifier.width(100.dp)
                    ) { Text("Agregar") }
                }
            }
        }

        Button(
            onClick = {
                navController.navigate("home") {
                    popUpTo("catalogo") { inclusive = true }
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
