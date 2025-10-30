package com.example.libreriasfiterror.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.libreriasfiterror.model.Libro

class CartViewModel : ViewModel() {
    var carrito = mutableStateListOf<Libro>()
        private set

    fun addLibroAlCarrito(libro: Libro) {
        carrito.add(libro)
    }

    fun clearCart() {
        carrito.clear()
    }
}


