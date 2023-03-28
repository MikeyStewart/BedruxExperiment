package com.mstewart.bedruxexperiment.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mstewart.bedruxexperiment.arch.ViewData
import com.mstewart.bedruxexperiment.arch.View

@Composable
fun Screen(
    viewData: ViewData,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        for (view in viewData.content) {
            View(viewData = view)
        }
    }
}