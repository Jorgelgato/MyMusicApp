package com.bobrek.mymusicapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobrek.mymusicapp.databinding.FragmentFavoritesBinding
import com.bobrek.mymusicapp.domain.model.Track
import com.bobrek.mymusicapp.ui.view.adapter.FavoriteAdapter
import com.bobrek.mymusicapp.ui.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val favoriteViewModel: FavoritesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteViewModel.getFavorites()
    }

    override fun onStart() {
        super.onStart()
        favoriteViewModel.favoritesModel.observe(this) {
            initRecyclerView(it)
        }
    }


    private fun initRecyclerView(list: List<Track>) {
        binding.recyclerFavorites.layoutManager = LinearLayoutManager(context)
        binding.recyclerFavorites.adapter = FavoriteAdapter(list) { onTrackClicked(it) }
    }

    private fun onTrackClicked(track: Track) {
        //TODO start playing
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater,container, false)
        return binding.root
    }

}