package com.bobrek.mymusicapp.data.repositories

import com.bobrek.mymusicapp.data.network.TrackService
import com.bobrek.mymusicapp.data.providers.TrackProvider
import com.bobrek.mymusicapp.domain.model.Track
import com.bobrek.mymusicapp.domain.model.toDomain
import javax.inject.Inject

class TrackRepository @Inject constructor(
    private val api: TrackService,
    private val trackProvider: TrackProvider
) {
    suspend fun getFavorites(): List<Track> {
        val response = api.getFavorites().map { it.toDomain() }
        trackProvider.tracks = response
        return response
    }
}