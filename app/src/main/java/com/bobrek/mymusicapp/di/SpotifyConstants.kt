package com.bobrek.mymusicapp.di

import com.spotify.android.appremote.api.SpotifyAppRemote

object SpotifyConstants {
    const val CLIENT_ID = "aec02d0f18f3419ab194242d4df1baf0"
    const val REDIRECT_URI = "com.bobrek.mymusicapp://callback"
    lateinit var TOKEN: String
    lateinit var mSpotifyAppRemote: SpotifyAppRemote

    fun player() = mSpotifyAppRemote.playerApi

    fun user() = mSpotifyAppRemote.userApi

    fun play(uri: String) {
        player().play(uri)
    }

    fun pause() {
        player().pause()
    }

    fun resume() {
        player().resume()
    }

    fun add(uri: String) {
        user().addToLibrary(uri)
    }

    fun remove(uri: String) {
        user().removeFromLibrary(uri)
    }

    fun next() {
        player().skipNext()
    }

    fun prev() {
        player().skipPrevious()
    }

}