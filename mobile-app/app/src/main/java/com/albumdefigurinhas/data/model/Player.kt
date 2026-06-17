package com.albumdefigurinhas.data.model

data class Player(
    val name: String,
    val position: String,
    val number: Int,
    val photo: String,
    val isStar: Boolean? = false,
    val about: String,
    val statistics: Statistics
)

data class Statistics(
    val matches: Int,
    val goals: Int,
    val assists: Int
)