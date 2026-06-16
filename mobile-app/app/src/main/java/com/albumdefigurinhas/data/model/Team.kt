package com.albumdefigurinhas.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams_table")
data class Team(
    @PrimaryKey val name: String,
    val description: String,
    val badge: String,
    val colors: List<String>,
    val players: List<Player>,
    val coach: Coach
)