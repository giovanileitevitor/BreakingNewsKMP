package com.course.breakingnews.features.favorites.state

sealed interface FavoriteState {
    data object Idle : FavoriteState
    data object Loading : FavoriteState
    data object OnBackPressed: FavoriteState

}