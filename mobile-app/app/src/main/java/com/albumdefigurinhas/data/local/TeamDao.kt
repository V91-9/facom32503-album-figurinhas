package com.albumdefigurinhas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albumdefigurinhas.data.model.Team
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    suspend fun insertAll(teams: List<Team>)

    fun getAllTeams(): Flow<List<Team>>

    @Query("SELECT * FROM teams_table WHERE name = :teamName")
    suspend fun getTeamByName(teamName: String): Team
}