package com.albumdefigurinhas.data.local

import androidx.room.TypeConverter
import com.albumdefigurinhas.data.model.Coach
import com.albumdefigurinhas.data.model.CountryInfo
import com.albumdefigurinhas.data.model.Player
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromPlayerList(value: List<Player>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toPlayerList(value: String): List<Player> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromCoach(value: Coach): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toCoach(value: String): Coach {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromCountryInfo(value: CountryInfo): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toCountryInfo(value: String): CountryInfo {
        return Json.decodeFromString(value)
    }
}