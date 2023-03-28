package com.mstewart.bedruxexperiment.ui.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    text: String,
    colour: String
) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(
                android.graphics.Color.parseColor(
                    colour
                )
            )
        ),
        onClick = { /*TODO*/ }
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton("Tap me!", "#DE5053")
}