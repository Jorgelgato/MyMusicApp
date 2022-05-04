package com.bobrek.mymusicapp.domain

import com.bobrek.mymusicapp.data.repositories.TrackRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: TrackRepository
) {
    suspend operator fun invoke() = repository.getFavorites()
}