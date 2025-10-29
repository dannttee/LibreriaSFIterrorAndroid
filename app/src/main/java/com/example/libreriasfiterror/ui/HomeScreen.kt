package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel

@Composable
fun HomeScreen(navController: NavController, userAdminViewModel: UserAdminViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido a la tienda", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("catalogo") }, modifier = Modifier.fillMaxWidth()) {
            Text("Catálogo")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("carrito") }, modifier = Modifier.fillMaxWidth()) {
            Text("Carrito")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("info") }, modifier = Modifier.fillMaxWidth()) {
            Text("Quiénes somos")
        }
        Spacer(modifier = Modifier.height(24.dp))
        if (userAdminViewModel.isAdmin) {
            Divider()
            Spacer(modifier = Modifier.height(14.dp))
            Text("Opciones de administración", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { navController.navigate("panelAdmin") }, modifier = Modifier.fillMaxWidth()) {
                Text("Panel de administrador")
            }
        }
    }
}

