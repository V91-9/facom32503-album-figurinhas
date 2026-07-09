package com.albumdefigurinhas.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Statistics(
    @SerialName("matches") val matches: Int,
    @SerialName("goals") val goals: Int,
    @SerialName("assists") val assists: Int
)