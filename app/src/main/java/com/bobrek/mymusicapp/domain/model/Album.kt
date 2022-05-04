package com.bobrek.mymusicapp.domain.model

data class Album(
    val album_type: String?,
    val artists: List<User>?,
    val available_markets: List<String>?,
    val external_urls: Any?,
    val href: String?,
    val id: String?,
    val images: List<Image>?,
    val name: String?,
    val release_date: String?,
    val release_date_precision: String?,
    val total_tracks: Int?,
    val type: String?,
    val uri: String?
)