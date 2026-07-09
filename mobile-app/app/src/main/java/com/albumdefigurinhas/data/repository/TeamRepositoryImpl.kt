package com.albumdefigurinhas.data.repository

import com.albumdefigurinhas.data.local.TeamDao
import com.albumdefigurinhas.data.remote.ApiService
import com.albumdefigurinhas.data.model.Team
import com.albumdefigurinhas.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamDao: TeamDao,
    private val apiService: ApiService
) : TeamRepository {

    override fun getAllTeams(): Flow<List<Team>> {
        return teamDao.getAllTeams()
    }

    override suspend fun refreshTeams() {
        try {
            val remoteTeams = apiService.getTeams() 
            
            teamDao.insertAll(remoteTeams)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}