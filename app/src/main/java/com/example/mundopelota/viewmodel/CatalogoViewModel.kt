package com.example.mundopelota.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mundopelota.model.Pelota
import com.example.mundopelota.model.CategoriaPelota

class CatalogoViewModel : ViewModel() {
    var pelotas = mutableStateListOf<Pelota>()
        private set

    init {
        pelotas.addAll(
            listOf(
                Pelota(1, "Adidas Copa Mundial", 15990.0, "Balón oficial de fútbol", CategoriaPelota.FUTBOL),
                Pelota(2, "Nike Premier League", 17990.0, "Balón réplica Premier League", CategoriaPelota.FUTBOL),
                Pelota(3, "Molten B7G4500", 22990.0, "Balón profesional de básquetbol", CategoriaPelota.BASKETBALL),
                Pelota(4, "Spalding TF-1000", 24990.0, "Para partidos internacionales", CategoriaPelota.BASKETBALL),
                Pelota(5, "Mikasa V200W", 19990.0, "Balón olímpico de vóleibol", CategoriaPelota.VOLLEYBALL),
                Pelota(6, "Molten V5M5000", 18990.0, "Balón FIVB Oficial", CategoriaPelota.VOLLEYBALL)
            )
        )
    }

    fun addPelota(pelota: Pelota) { pelotas.add(pelota) }
    fun removePelota(pelota: Pelota) { pelotas.remove(pelota) }
    fun updatePelota(pelotaActualizada: Pelota) {
        val indice = pelotas.indexOfFirst { it.id == pelotaActualizada.id }
        if (indice >= 0) {
            pelotas[indice] = pelotaActualizada
        }
    }
}




