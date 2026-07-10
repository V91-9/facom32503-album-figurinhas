package com.albumdefigurinhas.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.albumdefigurinhas.data.model.Team

@Database(entities = [Team::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao

}