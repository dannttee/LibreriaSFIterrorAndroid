package com.example.libreriasfiterror.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.libreriasfiterror.repository.LibroRepository

class LibroViewModel : ViewModel() {

    private val repository = LibroRepository()

    val libros = liveData {
        emit(repository.obtenerLibros())
    }
}
