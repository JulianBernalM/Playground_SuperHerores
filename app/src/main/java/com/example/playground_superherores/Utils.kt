package com.example.playground_superherores

object Routes {
    //Será la pantalla principal donde veremos todos los superhéroes.
    const val LISTA = "lista"

    //Representa la pantalla de detalle
    const val DETALLE = "detalle/{id}"

    //Nos permitirá construir una ruta
    fun detalle(id: Int) = "detalle/$id"
}