package com.example.libreriasfiterror.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.libreriasfiterror.model.Libro
import com.example.libreriasfiterror.repository.LibroRepository

class LibroViewModel : ViewModel() {

    private val _libros = mutableStateListOf<Libro>().apply {
        addAll(LibroRepository.getLibros())
    }
    val libros: SnapshotStateList<Libro> get() = _libros


    private val _carrito = mutableStateListOf<Libro>()
    val carrito: SnapshotStateList<Libro> get() = _carrito


    fun agregarAlCarrito(libro: Libro) {
        _carrito.add(libro)
    }

    fun eliminarDelCarrito(libro: Libro) {
        _carrito.remove(libro)
    }

    fun limpiarCarrito() {
        _carrito.clear()
    }


    fun agregarAlCatalogo(libro: Libro) {
        _libros.add(libro)
    }

    fun eliminarDelCatalogo(libro: Libro) {
        _libros.remove(libro)
    }
}
