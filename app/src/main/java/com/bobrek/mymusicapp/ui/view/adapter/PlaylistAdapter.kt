package com.bobrek.mymusicapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobrek.mymusicapp.R
import com.bobrek.mymusicapp.domain.model.Playlist
import com.bobrek.mymusicapp.ui.view.viewholder.PlaylistViewHolder

class PlaylistAdapter(
    private val playlistList: List<Playlist>,
    private val onClickListener: (Playlist) -> Unit
) : RecyclerView.Adapter<PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlaylistViewHolder(layoutInflater.inflate(R.layout.item_playlist, parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val item = playlistList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = playlistList.size
}