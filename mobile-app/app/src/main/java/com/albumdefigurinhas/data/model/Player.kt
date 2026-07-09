package com.albumdefigurinhas.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    @SerialName("name") val name: String,
    @SerialName("position") val position: String,
    @SerialName("number") val number: Int,
    @SerialName("photo") val photo: String,
    @SerialName("about") val about: String,
    @SerialName("statistics") val statistics: Statistics,
    @SerialName("isStar") val isStar: Boolean = false 
)