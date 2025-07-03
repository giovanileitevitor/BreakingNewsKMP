package com.course.breakingnews.ui.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import breakingnews.composeapp.generated.resources.Res
import breakingnews.composeapp.generated.resources.breaking_news_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun BreakingNewsTopBar(
    modifier: Modifier = Modifier,
    onClickSettings: () -> Unit,
    onClickFavorites: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .height(56.dp)
    ) {
//        Image(
//            painter = painterResource(Res.drawable.breaking_news_logo),
//            contentDescription = null,
//            modifier = modifier.align(Alignment.CenterStart).height(56.dp)
//        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                tint = Color.Black,
                modifier = modifier
                    .size(36.dp)
                    .clickable { onClickSettings.invoke() }
            )
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color.Red,
                modifier = modifier
                    .size(36.dp)
                    .clickable { onClickFavorites.invoke() }
            )
        }
    }
}

@Preview()
@Composable
private fun PreviewTopBar(){
    BreakingNewsTopBar(
        onClickSettings = {},
        onClickFavorites = {}
    )
}