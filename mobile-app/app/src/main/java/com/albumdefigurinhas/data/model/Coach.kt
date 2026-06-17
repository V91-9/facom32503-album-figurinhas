package com.albumdefigurinhas.data.model

data class Coach(
    val name: String,
    val photo: String,
    val role: String? = "Treinador",
    val about: String
)