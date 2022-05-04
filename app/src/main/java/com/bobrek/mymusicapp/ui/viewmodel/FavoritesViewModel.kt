package com.bobrek.mymusicapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobrek.mymusicapp.domain.GetFavoritesUseCase
import com.bobrek.mymusicapp.domain.model.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase
) : ViewModel() {

    val favoritesModel = MutableLiveData<List<Track>>()

    fun getFavorites() {
        viewModelScope.launch {
            val result = getFavoritesUseCase()
            if (!result.isNullOrEmpty()) {
                favoritesModel.postValue(result)
            }
        }
    }
}