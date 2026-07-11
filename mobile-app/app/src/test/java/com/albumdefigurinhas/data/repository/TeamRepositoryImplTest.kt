package com.albumdefigurinhas.data.repository

import com.albumdefigurinhas.data.local.TeamDao
import com.albumdefigurinhas.data.model.Team
import com.albumdefigurinhas.data.model.Competition
import com.albumdefigurinhas.data.remote.AlbumApiService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TeamRepositoryImplTest {
    private lateinit var mockDao: TeamDao
    private lateinit var mockApi: AlbumApiService
    private lateinit var repository: TeamRepositoryImpl

    @Before
    fun setup() {
        mockDao = mockk(relaxed = true)
        mockApi = mockk()
        repository = TeamRepositoryImpl(mockDao, mockApi)
    }

    @Test
    fun `quando refreshTeams for chamado com sucesso, DEVE buscar da API e salvar no banco local`() = runTest {
        val fakeTeam = mockk<Team>(relaxed = true)
        val fakeTeamList = listOf(fakeTeam)

        val fakeCompetition = Competition(
            name = "FIFA World Cup 2026",
            edition = "23",
            trophyImage = "trofeu",
            teams = fakeTeamList
        )

        coEvery { mockApi.getCompetitionData() } returns fakeCompetition
        repository.refreshTeams()
        coVerify(exactly = 1) { mockDao.insertAll(fakeTeamList) }
    }
}