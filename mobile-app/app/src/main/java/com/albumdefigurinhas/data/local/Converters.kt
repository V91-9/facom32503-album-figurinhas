package com.albumdefigurinhas.data.local

import androidx.room.TypeConverter
import com.albumdefigurinhas.data.model.Coach
import com.albumdefigurinhas.data.model.Player
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromPlayerList(value: List<Player>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPlayerList(value: String): List<Player> {
        val listType = object : TypeToken<List<Player>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromCoach(value: Coach): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toCoach(value: String): Coach {
        return gson.fromJson(value, Coach::class.java)
    }
}