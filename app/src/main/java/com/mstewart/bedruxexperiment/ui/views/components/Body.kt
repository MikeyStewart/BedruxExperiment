package com.mstewart.bedruxexperiment.ui.views.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Body(text: String) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = text,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun BodyPreview() {
    Body(text = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. In cursus turpis massa tincidunt dui. In fermentum posuere urna nec tincidunt praesent semper. Sit amet est placerat in egestas erat imperdiet sed euismod. Volutpat consequat mauris nunc congue. Pellentesque habitant morbi tristique senectus et netus. Blandit libero volutpat sed cras ornare arcu. Mollis nunc sed id semper risus. Porttitor lacus luctus accumsan tortor posuere ac ut. Felis donec et odio pellentesque diam volutpat commodo. Penatibus et magnis dis parturient montes nascetur ridiculus.
    """.trimIndent())
}