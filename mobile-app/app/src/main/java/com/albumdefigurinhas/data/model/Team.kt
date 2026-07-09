package com.albumdefigurinhas.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "teams_table")
data class Team(
    @PrimaryKey 
    @SerialName("name") val name: String,
    @SerialName("code") val code: String,
    @SerialName("iso2") val iso2: String,
    @SerialName("victories") val victories: Int,
    @SerialName("description") val description: String,
    @SerialName("badge") val badge: String,
    @SerialName("colors") val colors: List<String>,
    @SerialName("countryInfo") val countryInfo: CountryInfo,
    @SerialName("players") val players: List<Player>,
    @SerialName("coach") val coach: Coach
)