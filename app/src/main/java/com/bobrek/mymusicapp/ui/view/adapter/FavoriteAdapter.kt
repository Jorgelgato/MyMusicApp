package com.bobrek.mymusicapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobrek.mymusicapp.R
import com.bobrek.mymusicapp.domain.model.Track
import com.bobrek.mymusicapp.ui.view.viewholder.FavoriteViewHolder

class FavoriteAdapter(
    private val favoritesList: List<Track>,
    private val onClickListener: (Track) -> Unit
) : RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(layoutInflater.inflate(R.layout.item_favorite, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoritesList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = favoritesList.size
}