package com.course.breakingnews.features.favorites.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.course.breakingnews.features.favorites.state.FavoriteState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private var _state: MutableStateFlow<FavoriteState> =
        MutableStateFlow(FavoriteState.Loading)
    val state: StateFlow<FavoriteState> = _state

    fun fetchFavorite(){
        viewModelScope.launch {
            delay(2000)
            _state.value = FavoriteState.Idle
        }
    }
}