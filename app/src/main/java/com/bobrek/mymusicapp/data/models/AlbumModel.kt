package com.bobrek.mymusicapp.data.models

data class AlbumModel(
    val album_type: String?,
    val artists: List<UserModel>?,
    val available_markets: List<String>?,
    val external_urls: Any?,
    val href: String?,
    val id: String?,
    val images: List<ImageModel>?,
    val name: String?,
    val release_date: String?,
    val release_date_precision: String?,
    val total_tracks: Int?,
    val type: String?,
    val uri: String?
)