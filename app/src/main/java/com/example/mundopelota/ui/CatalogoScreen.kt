package com.example.mundopelota.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.mundopelota.viewmodel.CatalogoViewModel
import com.example.mundopelota.model.Pelota
import com.example.mundopelota.viewmodel.UserAdminViewModel

@Composable
fun CatalogoScreen(
    navController: NavController,
    catalogoViewModel: CatalogoViewModel,
    onAgregarAlCarrito: (Pelota) -> Unit = {},
    userAdminViewModel: UserAdminViewModel
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Catálogo de pelotas", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))

        catalogoViewModel.pelotas.forEach { pelota ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(pelota.nombre, style = MaterialTheme.typography.bodyLarge)
                    Text("Precio: ${pelota.precio} | ${pelota.categoria.name.replace('_',' ')}", style = MaterialTheme.typography.bodySmall)
                    Text(pelota.descripcion, style = MaterialTheme.typography.bodySmall)
                }
                Button(
                    onClick = { onAgregarAlCarrito(pelota) },
                    modifier = Modifier.padding(start = 4.dp)
                ) { Text("Agregar") }
            }
            Divider()
        }
        Button(
            onClick = { navController.navigateUp() },
            modifier = Modifier.padding(top = 12.dp)
        ) { Text("Volver") }
    }
}




