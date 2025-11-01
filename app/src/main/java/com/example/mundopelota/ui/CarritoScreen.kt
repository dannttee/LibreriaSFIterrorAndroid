package com.example.mundopelota.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mundopelota.viewmodel.CartViewModel

@Composable
fun CarritoScreen(navController: NavController, cartViewModel: CartViewModel) {
    val cartBalls = cartViewModel.carrito

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Carrito de compras", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        if (cartBalls.isNotEmpty()) {
            cartBalls.forEach { pelota ->
                Card(
                    Modifier
                        .padding(vertical = 6.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.padding(12.dp)) {
                        // Muestra nombre y precio de la pelota
                        Text("${pelota.nombre} - \$${pelota.precio}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
            Spacer(Modifier.height(18.dp))
            Button(
                onClick = {
                    cartViewModel.clearCart()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar compra")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {
                    cartViewModel.clearCart()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Vaciar carrito")
            }
        } else {
            Text("Tu carrito está vacío.", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
