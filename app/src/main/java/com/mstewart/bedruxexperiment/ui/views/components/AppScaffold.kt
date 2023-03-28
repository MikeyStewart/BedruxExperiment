package com.mstewart.bedruxexperiment.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.mstewart.bedruxexperiment.arch.ViewData

@Composable
fun AppScaffold(screensData: List<ViewData>) {

    val currentScreenIndex = rememberSaveable {
        mutableStateOf(0)
    }

    val bottomNav: @Composable () -> Unit = {
        if (screensData.size > 1) {
            NavigationBar {
                screensData.forEach { screen ->
                    NavigationBarItem(
                        selected = currentScreenIndex.value == screensData.indexOf(screen),
                        onClick = {
                            currentScreenIndex.value = screensData.indexOf(screen)
                        },
                        label = { Text(text = (screen.getValueOf("name")) as String) },
                        icon = { Icon(imageVector = screen.getIcon(), contentDescription = null) }
                    )
                }
            }
        }
    }

    Scaffold(
        bottomBar = bottomNav,
        content = { contentPadding ->
            screensData.find {
                screensData.indexOf(it) == currentScreenIndex.value
            }?.let { screenData ->
                Screen(
                    viewData = screenData,
                    modifier = Modifier
                        .padding(contentPadding)
                )
            }
        }
    )
}

fun ViewData.getValueOf(key: String): Any {
    return content.firstOrNull {
        it.first == key
    }?.second ?: "null"
}