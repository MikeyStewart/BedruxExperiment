package com.mstewart.bedruxexperiment.arch

import androidx.compose.runtime.Composable
import com.mstewart.bedruxexperiment.ui.views.components.Body
import com.mstewart.bedruxexperiment.ui.views.components.Carousel
import com.mstewart.bedruxexperiment.ui.views.components.Header
import com.mstewart.bedruxexperiment.ui.views.components.PrimaryButton

@Suppress("UNCHECKED_CAST")
@Composable
fun View(viewData: Pair<String, Any>) {
    when(viewData.first) {
        "header" -> {
            Header(text = viewData.second as String)
        }
        "body" -> {
            Body(text = viewData.second as String)
        }
        "button" -> {
            val buttonData = viewData.second as List<Pair<String, Any>>
            PrimaryButton(
                text = buttonData.firstOrNull { it.first == "text" }?.second as String,
                colour = buttonData.firstOrNull { it.first == "colour" }?.second as String
            )
        }
        "carousel" -> {
            val carouselData = viewData.second as List<Pair<String, Any>>
            Carousel(
                title = carouselData.firstOrNull { it.first == "title" }?.second as String,
                items = carouselData.firstOrNull { it.first == "items" }?.second as List<String>,
            )
        }
        else -> {
            // TODO: handle errors
        }
    }
}