package com.course.breakingnews.features.details.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.course.breakingnews.features.details.action.DetailsAction
import com.course.breakingnews.features.details.state.DetailsState
import com.course.breakingnews.features.details.viewmodel.DetailsViewModel
import com.course.breakingnews.ui.content.DetailsContentSection
import com.course.breakingnews.ui.header.DetailsHeaderSection
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailsScreen(
    onBackPressed: () -> Unit
) {

    val viewModel = koinViewModel<DetailsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    DetailsContent(
        state = state,
        action = viewModel::submitAction,
        onBackPressed = onBackPressed
    )
}

@Composable
fun DetailsContent(
    state: DetailsState,
    action: (DetailsAction) -> Unit,
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

                when (state){
                    is DetailsState.Idle -> {}
                    is DetailsState.Loading -> {}
                    is DetailsState.OnBackPressed -> {
                        action(DetailsAction.Idle)
                        onBackPressed.invoke()
                    }
                }

                DetailsHeaderSection(onClick = { action(DetailsAction.RequestOnBackPressed) })

                DetailsContentSection(
                    content = """
                    LONDON — Cryptocurrencies “have no intrinsic value” and people who invest in them should be prepared to lose all their money, Bank of England Governor Andrew Bailey said.

                    Digital currencies like bitcoin, ether and even dogecoin have been on a tear this year, reminding some investors of the 2017 crypto bubble in which bitcoin blasted toward $20,000, only to sink as low as $3,122 a year later.

                    Asked at a press conference Thursday about the rising value of cryptocurrencies, Bailey said: “They have no intrinsic value. That doesn’t mean to say people don’t put value on them, because they can have extrinsic value. But they have no intrinsic value.”
                """.trimIndent()
                )
            }
        }
    )
}