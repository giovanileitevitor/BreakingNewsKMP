package com.course.breakingnews.features.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.course.breakingnews.ui.card.BreakingNewsCard
import com.course.breakingnews.ui.top.BreakingNewsTopBar

@Composable
fun HomeScreen(
    navigateToDetailsScreen: () -> Unit,
    navigateToAboutScreen: () -> Unit
) {
    HomeContent(
        navigateToDetailsScreen = navigateToDetailsScreen,
        navigateToAboutScreen = navigateToAboutScreen
    )
}

@Composable
fun HomeContent(
    navigateToDetailsScreen: () -> Unit,
    navigateToAboutScreen: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            BreakingNewsTopBar(onClick = { navigateToAboutScreen.invoke() })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Breaking News",
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )

                BreakingNewsCard(
                    title = "5 things to know about the 'conundrum' of lupus",
                    author = "Matt Villano",
                    date = "Sunday, 9 May 2021",
                    onClick = { navigateToDetailsScreen.invoke() }
                )

                BreakingNewsCard(
                    title = "5 things to know about the 'conundrum' of lupus",
                    author = "Matt Villano",
                    date = "Sunday, 9 May 2021",
                    onClick = { navigateToDetailsScreen.invoke() }
                )
            }
        }
    )
}