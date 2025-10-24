package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.libreriasfiterror.viewmodel.UsuarioViewModel

@Composable
fun RegistroScreen(navController: NavController, usuarioViewModel: UsuarioViewModel = viewModel()) {
    val uiState by usuarioViewModel.uiState.collectAsState()
    val errores by usuarioViewModel.errores.collectAsState()

    Column(modifier = Modifier.padding(24.dp)) {
        Text("Registro de usuario", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        // Campo Nombre
        OutlinedTextField(
            value = uiState.nombre,
            onValueChange = { usuarioViewModel.onChange(uiState.copy(nombre = it)) },
            label = { Text("Nombre") },
            isError = errores.nombre != null,
            modifier = Modifier.fillMaxWidth()
        )
        errores.nombre?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Spacer(Modifier.height(8.dp))

        // Campo Correo
        OutlinedTextField(
            value = uiState.correo,
            onValueChange = { usuarioViewModel.onChange(uiState.copy(correo = it)) },
            label = { Text("Correo electrónico") },
            isError = errores.correo != null,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        errores.correo?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Spacer(Modifier.height(8.dp))

        // Campo Contraseña CON ASTERISCOS (sin botón)
        OutlinedTextField(
            value = uiState.contrasena,
            onValueChange = { usuarioViewModel.onChange(uiState.copy(contrasena = it)) },
            label = { Text("Contraseña") },
            isError = errores.contrasena != null,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        errores.contrasena?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Spacer(Modifier.height(8.dp))

        // Campo Dirección
        OutlinedTextField(
            value = uiState.direccion,
            onValueChange = { usuarioViewModel.onChange(uiState.copy(direccion = it)) },
            label = { Text("Dirección") },
            isError = errores.direccion != null,
            modifier = Modifier.fillMaxWidth()
        )
        errores.direccion?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Spacer(Modifier.height(8.dp))

        // Checkbox Términos
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = uiState.aceptaTerminos,
                onCheckedChange = { usuarioViewModel.onChange(uiState.copy(aceptaTerminos = it)) }
            )
            Text("Acepto los términos y condiciones")
        }
        errores.aceptaTerminos?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Spacer(Modifier.height(24.dp))

        // Botón Registrar
        Button(
            onClick = { navController.navigate("resumen") },
            enabled = usuarioViewModel.esValido()
        ) {
            Text("Registrar")
        }
    }
}
