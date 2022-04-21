package com.bobrek.mymusicapp.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bobrek.mymusicapp.databinding.ItemPlaylistBinding
import com.bobrek.mymusicapp.domain.model.Playlist
import com.bumptech.glide.Glide

class PlaylistViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPlaylistBinding.bind(view)

    fun render(playlist: Playlist, onClickListener: (Playlist) -> Unit) {
        Glide.with(binding.ivPlaylist.context).load(playlist.images?.get(0)?.url)
            .into(binding.ivPlaylist)
        binding.txtTitle.text = playlist.name
        binding.txtOwner.text = playlist.owner.display_name
        itemView.setOnClickListener {
            onClickListener(playlist)
        }
    }
}