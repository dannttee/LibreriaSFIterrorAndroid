package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardActions
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun intentarLogin() {
        showError = false
        if (username == "admin" && password == "admin123") {
            navController.navigate("admin") {
                popUpTo("login") { inclusive = true }
            }
        } else if (username == "cliente" && password == "cliente123") {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        } else {
            showError = true
        }
        keyboardController?.hide()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { intentarLogin() }
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { intentarLogin() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }

        if (showError) {
            Spacer(modifier = Modifier.height(10.dp))
            Text("Credenciales incorrectas", color = MaterialTheme.colorScheme.error)
        }
    }
}
