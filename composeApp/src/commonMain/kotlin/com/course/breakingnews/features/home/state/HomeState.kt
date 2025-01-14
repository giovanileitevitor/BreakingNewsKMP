package com.course.breakingnews.features.home.state

sealed interface HomeState {
    data object Loading: HomeState
}