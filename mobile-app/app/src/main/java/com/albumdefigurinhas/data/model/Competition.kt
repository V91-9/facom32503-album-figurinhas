package com.albumdefigurinhas.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    @SerialName("name") val name: String,
    @SerialName("edition") val edition: String,
    @SerialName("trophyImage") val trophyImage: String,
    @SerialName("teams") val teams: List<Team>
)