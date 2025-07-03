package com.course.breakingnews.features.favorites.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.course.breakingnews.features.favorites.state.FavoriteState
import com.course.breakingnews.features.favorites.viewmodel.FavoriteViewModel
import com.course.breakingnews.ui.loading.Loading
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavoriteScreen(
    onBackPressed: () -> Unit
) {

    val viewModel = koinViewModel<FavoriteViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LifecycleEventEffect(
        event = Lifecycle.Event.ON_START,
    ){
        viewModel.fetchFavorite()
    }

    FavoriteContent(
        state = state,
        onBackPressed = onBackPressed
    )
}

@Composable
fun FavoriteContent(
    state: FavoriteState,
    onBackPressed: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {},
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when(state){
                    is FavoriteState.Loading -> Loading()
                    is FavoriteState.OnBackPressed -> {
                        onBackPressed.invoke()
                    }
                    is FavoriteState.Idle -> {
                        Text(text = "Tela de Favorites")
                    }
                }
            }
        }
    )
}