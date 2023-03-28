package com.mstewart.bedruxexperiment.ui.views.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Carousel(
    title: String,
    items: List<String>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            items.forEach {
                GlideImage(
                    imageModel = { it },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}