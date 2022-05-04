package com.bobrek.mymusicapp.data.providers

import com.bobrek.mymusicapp.domain.model.Track
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrackProvider @Inject constructor(){
    var tracks: List<Track> = emptyList()
}