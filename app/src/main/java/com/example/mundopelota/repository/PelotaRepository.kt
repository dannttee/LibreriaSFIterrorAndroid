package com.example.mundopelota.repository

import com.example.mundopelota.model.Pelota
import com.example.mundopelota.model.CategoriaPelota

object PelotaRepository {
    private val pelotasIniciales = listOf(
        Pelota(1, "Molten GG7X", 19990.0, "Pelota profesional de basketball, tamaño 7", CategoriaPelota.BASKETBALL),
        Pelota(2, "Spalding NBA", 23990.0, "Pelota oficial de basketball NBA", CategoriaPelota.BASKETBALL),
        Pelota(3, "Adidas Tango", 17990.0, "Pelota de fútbol tradicional, resistente al agua", CategoriaPelota.FUTBOL),
        Pelota(4, "Nike Flight", 24990.0, "Pelota de fútbol alta competición", CategoriaPelota.FUTBOL),
        Pelota(5, "Mikasa V200W", 27990.0, "Pelota oficial de voleyball olímpico", CategoriaPelota.VOLLEYBALL),
        Pelota(6, "Wilson AVP", 15990.0, "Pelota de voleyball para juegos playeros", CategoriaPelota.VOLLEYBALL)
    )

    fun getPelotas(): List<Pelota> = pelotasIniciales
}


