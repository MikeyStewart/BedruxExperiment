package com.mstewart.bedruxexperiment.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.mstewart.bedruxexperiment.arch.ViewData
import java.util.*

fun ViewData.getIcon(): ImageVector =
    when ((getValueOf("name") as String).lowercase(Locale.getDefault())) {
        "home" -> Icons.Default.Home
        "search" -> Icons.Default.Search
        else -> Icons.Default.Favorite // TODO: handle error
    }