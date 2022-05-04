package com.bobrek.mymusicapp.data.network

import com.bobrek.mymusicapp.data.models.TrackInfo
import com.bobrek.mymusicapp.data.models.TrackModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TrackService @Inject constructor(
    private val api: SpotifyApiClient,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun getFavorites(): List<TrackModel> {
        return withContext(dispatcher) {
            api.getFavorites(0, 50).body()?.items?.map {
                Gson().fromJson(
                    it,
                    TrackInfo::class.java
                )
            }?.map { it.track } ?: emptyList()
        }
    }
}
/*
fun test(): List<TrackModel> {
    val s = "[" +
            " {" +
            "   \"added_at\": \"2022-04-19T21:30:05Z\"," +
            "   \"track\": {" +
            "     \"album\": {" +
            "       \"album_type\": \"album\"," +
            "       \"artists\": [" +
            "         {" +
            "           \"external_urls\": {" +
            "             \"spotify\": \"https://open.spotify.com/artist/5bgW1AysTzHav20snaPkyp\"" +
            "           }," +
            "           \"href\": \"https://api.spotify.com/v1/artists/5bgW1AysTzHav20snaPkyp\"," +
            "           \"id\": \"5bgW1AysTzHav20snaPkyp\"," +
            "           \"name\": \"Imperial Circus Dead Decadence\"," +
            "           \"type\": \"artist\"," +
            "           \"uri\": \"spotify:artist:5bgW1AysTzHav20snaPkyp\"" +
            "         }" +
            "       ]," +
            "       \"external_urls\": {" +
            "         \"spotify\": \"https://open.spotify.com/album/4bhpv21IKNHsu60LGQCmox\"" +
            "       }," +
            "       \"href\": \"https://api.spotify.com/v1/albums/4bhpv21IKNHsu60LGQCmox\"," +
            "       \"id\": \"4bhpv21IKNHsu60LGQCmox\"," +
            "       \"images\": [" +
            "         {" +
            "           \"height\": 640," +
            "           \"url\": \"https://i.scdn.co/image/ab67616d0000b27397e5d28c41fd6bb2b83b5778\"," +
            "           \"width\": 640" +
            "         }," +
            "         {" +
            "           \"height\": 300," +
            "           \"url\": \"https://i.scdn.co/image/ab67616d00001e0297e5d28c41fd6bb2b83b5778\"," +
            "           \"width\": 300" +
            "         }," +
            "         {" +
            "           \"height\": 64," +
            "           \"url\": \"https://i.scdn.co/image/ab67616d0000485197e5d28c41fd6bb2b83b5778\"," +
            "           \"width\": 64" +
            "         }" +
            "       ]," +
            "       \"name\": \"狂おしく咲いた凄惨な骸は奏で、愛おしく裂いた少女は聖餐の詞を謳う。\"," +
            "       \"release_date\": \"2011-11-09\"," +
            "       \"release_date_precision\": \"day\"," +
            "       \"total_tracks\": 11," +
            "       \"type\": \"album\"," +
            "       \"uri\": \"spotify:album:4bhpv21IKNHsu60LGQCmox\"" +
            "     }," +
            "     \"artists\": [" +
            "       {" +
            "         \"external_urls\": {" +
            "           \"spotify\": \"https://open.spotify.com/artist/5bgW1AysTzHav20snaPkyp\"" +
            "         }," +
            "         \"href\": \"https://api.spotify.com/v1/artists/5bgW1AysTzHav20snaPkyp\"," +
            "         \"id\": \"5bgW1AysTzHav20snaPkyp\"," +
            "         \"name\": \"Imperial Circus Dead Decadence\"," +
            "         \"type\": \"artist\"," +
            "         \"uri\": \"spotify:artist:5bgW1AysTzHav20snaPkyp\"" +
            "       }" +
            "     ]," +
            "     \"disc_number\": 1," +
            "     \"duration_ms\": 542600," +
            "     \"explicit\": false," +
            "     \"external_ids\": {" +
            "       \"isrc\": \"JPV751900923\"" +
            "     }," +
            "     \"external_urls\": {" +
            "       \"spotify\": \"https://open.spotify.com/track/2iYsZ5TowQRZFOa0bYPUc7\"" +
            "     }," +
            "     \"href\": \"https://api.spotify.com/v1/tracks/2iYsZ5TowQRZFOa0bYPUc7\"," +
            "     \"id\": \"2iYsZ5TowQRZFOa0bYPUc7\"," +
            "     \"is_local\": false," +
            "     \"is_playable\": true," +
            "     \"name\": \"謳\"," +
            "     \"popularity\": 45," +
            "     \"preview_url\": \"https://p.scdn.co/mp3-preview/04d387dfcb122cebcf62d1a8e6fd13df8a2030fd?cid=774b29d4f13844c495f206cafdad9c86\"," +
            "     \"track_number\": 10," +
            "     \"type\": \"track\"," +
            "     \"uri\": \"spotify:track:2iYsZ5TowQRZFOa0bYPUc7\"" +
            "   }" +
            " }" +
            "]"
    return Gson().fromJson(s, Array<JsonElement>::class.java).map {
        Gson().fromJson(
            it,
            TrackInfo::class.java
        )
    }.map { it.track }
}
*/