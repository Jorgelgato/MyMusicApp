package com.bobrek.mymusicapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobrek.mymusicapp.databinding.FragmentHomeBinding
import com.bobrek.mymusicapp.domain.model.Playlist
import com.bobrek.mymusicapp.ui.view.adapter.PlaylistAdapter
import com.bobrek.mymusicapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.getPlaylists()
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.playlistModel.observe(this) {
            initRecyclerView(it)
        }
    }

    private fun initRecyclerView(list: List<Playlist>) {
        binding.recyclerPlaylists.layoutManager = LinearLayoutManager(context)
        binding.recyclerPlaylists.adapter = PlaylistAdapter(list) { onPlaylistClicked(it) }
    }

    private fun onPlaylistClicked(playlist: Playlist) {
        //TODO start playing
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

}