package com.albumdefigurinhas.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryInfo(
    @SerialName("population") val population: String,
    @SerialName("area") val area: String,
    @SerialName("continent") val continent: String,
    @SerialName("capital") val capital: String,
    @SerialName("language") val language: String,
    @SerialName("currency") val currency: String,
    @SerialName("gdp") val gdp: String,
    @SerialName("curiosity") val curiosity: String
)