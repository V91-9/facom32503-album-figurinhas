package com.albumdefigurinhas.data.remote

import com.albumdefigurinhas.data.model.Competition
import retrofit2.http.GET

interface AlbumApiService {
    @GET("competition")
    suspend fun getCompetitionData(): Competition
}