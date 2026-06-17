package com.albumdefigurinhas.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams_table")
data class Team(
    @PrimaryKey val name: String,
    val code: String,
    val iso2: String,
    val victories: Int,
    val description: String,
    val badge: String,
    val colors: List<String>,
    val countryInfo: CountryInfo,
    val players: List<Player>,
    val coach: Coach
    
)

data class CountryInfo(
    val population: String,
    val area: String,
    val continent: String,
    val capital: String,
    val language: String,
    val currency: String,
    val gdp: String,
    val curiosity: String
)