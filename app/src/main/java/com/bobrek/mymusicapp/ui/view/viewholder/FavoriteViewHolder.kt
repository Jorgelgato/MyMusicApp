package com.bobrek.mymusicapp.ui.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bobrek.mymusicapp.databinding.ItemFavoriteBinding
import com.bobrek.mymusicapp.domain.model.Track
import com.bobrek.mymusicapp.domain.model.User
import com.bumptech.glide.Glide

class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemFavoriteBinding.bind(view)

    fun render(track: Track, onClickListener: (Track) -> Unit) {
        Glide.with(binding.ivFavorite.context).load(track.album?.images?.get(1)?.url)
            .into(binding.ivFavorite)
        binding.txtTitle.text = track.name
        binding.txtArtists.text = getArtists(track.artists)
        itemView.setOnClickListener {
            onClickListener(track)
        }
    }

    private fun getArtists(artists: List<User>): String {
        var artistsNames = ""
        for (artist in artists){
            artistsNames += ("${artist.name}, ")
        }
        return artistsNames.dropLast(2)
    }
}