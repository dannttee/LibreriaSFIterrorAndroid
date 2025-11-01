package com.example.mundopelota.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mundopelota.model.Pelota

class CartViewModel : ViewModel() {
    var carrito = mutableStateListOf<Pelota>()
        private set

    fun addPelotaAlCarrito(pelota: Pelota) {
        carrito.add(pelota)
    }

    fun clearCart() {
        carrito.clear()
    }
}



