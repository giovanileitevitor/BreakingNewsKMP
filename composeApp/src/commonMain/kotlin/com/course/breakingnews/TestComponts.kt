package com.course.breakingnews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import breakingnews.composeapp.generated.resources.Res
import breakingnews.composeapp.generated.resources.breaking_news_logo
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.resources.painterResource

@Composable
fun DetailsScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Box {
            CoilImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                imageModel = { "https://images.unsplash.com/photo-1558980664-1b019a3a04ae?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxMTc3M3wwfDF8c2VhcmNofDJ8fGNyeXB0b3xlbnwwfHx8fDE2Nzg3NTg1MzQ&ixlib=rb-1.2.1&q=80&w=800" },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            )

            DetailsHeaderSection()
        }

        DetailsNewsContentSection(
            content = """
                    LONDON — Cryptocurrencies “have no intrinsic value” and people who invest in them should be prepared to lose all their money, Bank of England Governor Andrew Bailey said.

                    Digital currencies like bitcoin, ether and even dogecoin have been on a tear this year, reminding some investors of the 2017 crypto bubble in which bitcoin blasted toward $20,000, only to sink as low as $3,122 a year later.

                    Asked at a press conference Thursday about the rising value of cryptocurrencies, Bailey said: “They have no intrinsic value. That doesn’t mean to say people don’t put value on them, because they can have extrinsic value. But they have no intrinsic value.”
                """.trimIndent()
        )
    }

}

@Composable
fun DetailsHeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.LightGray, RoundedCornerShape(32)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun DetailsNewsContentSection(
    content: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.Gray.copy(alpha = 0.5f))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 24.sp
        )
    }
}

@Composable
fun BreakingNewsTopBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(56.dp)
    ) {

        Image(
            painter = painterResource(Res.drawable.breaking_news_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center).height(56.dp)
        )

        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .align(Alignment.CenterEnd)
                .clickable { onClick.invoke() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}