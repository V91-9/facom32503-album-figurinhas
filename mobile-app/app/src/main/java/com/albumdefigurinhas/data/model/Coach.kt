package com.albumdefigurinhas.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coach(
    @SerialName("name") val name: String,
    @SerialName("photo") val photo: String,
    @SerialName("role") val role: String? = "Treinador",
    @SerialName("about") val about: String? = null
)