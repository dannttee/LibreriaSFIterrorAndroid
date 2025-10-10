package com.example.libreriasfiterror.viewmodel

import LibroRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class LibroViewModel : ViewModel() {

    private val repository = LibroRepository()

    val libros = liveData {
        emit(repository.obtenerLibros())
    }
}
