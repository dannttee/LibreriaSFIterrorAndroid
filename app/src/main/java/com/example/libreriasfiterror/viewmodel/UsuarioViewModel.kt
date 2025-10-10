package com.example.libreriasfiterror.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.libreriasfiterror.ui.UsuarioUiState
import com.example.libreriasfiterror.ui.UsuarioErrores

class UsuarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioUiState())
    val uiState: StateFlow<UsuarioUiState> = _uiState

    private val _errores = MutableStateFlow(UsuarioErrores())
    val errores: StateFlow<UsuarioErrores> = _errores

    fun onChange(updated: UsuarioUiState) {
        _uiState.value = updated
        validar(updated)
    }

    private fun validar(usuario: UsuarioUiState) {
        val errores = UsuarioErrores(
            nombre = if (usuario.nombre.isBlank()) "Nombre requerido" else null,
            correo = if (!android.util.Patterns.EMAIL_ADDRESS.matcher(usuario.correo).matches()) "Correo inválido" else null,
            contrasena = if (usuario.contrasena.length < 6) "Contraseña muy corta" else null,
            direccion = if (usuario.direccion.isBlank()) "Dirección requerida" else null,
            aceptaTerminos = if (!usuario.aceptaTerminos) "Debes aceptar los términos" else null
        )
        _errores.value = errores
    }

    fun esValido(): Boolean =
        with(_errores.value) {
            nombre == null && correo == null && contrasena == null && direccion == null && aceptaTerminos == null
        }
}

