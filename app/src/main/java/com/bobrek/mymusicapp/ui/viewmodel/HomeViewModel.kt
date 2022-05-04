package com.bobrek.mymusicapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobrek.mymusicapp.domain.GetPlaylistsUseCase
import com.bobrek.mymusicapp.domain.model.Playlist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlaylistsUseCase: GetPlaylistsUseCase
) : ViewModel() {

    val playlistModel = MutableLiveData<List<Playlist>>()

    fun getPlaylists() {
        viewModelScope.launch {
            val result = getPlaylistsUseCase()
            if (!result.isNullOrEmpty()) {
                playlistModel.postValue(result)
            }
        }
    }
}