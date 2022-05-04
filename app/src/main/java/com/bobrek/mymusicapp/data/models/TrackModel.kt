package com.bobrek.mymusicapp.data.models


data class TrackModel(
    val album: AlbumModel?,
    val artists: List<UserModel>,
    val available_markets: List<String>?,
    val disk_number: Int?,
    val duration_ms: Int?,
    val explicit: Boolean?,
    val external_ids: Any?,
    val href: String?,
    val id: String?,
    val is_local: Boolean?,
    val name: String,
    val popularity: Int?,
    val preview_url: Any?,
    val track_number: Int,
    val type: String?,
    val uri: String
)