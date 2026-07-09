package com.albumdefigurinhas.domain.repository

import com.albumdefigurinhas.data.model.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getAllTeams(): Flow<List<Team>>
    
    suspend fun refreshTeams()
}