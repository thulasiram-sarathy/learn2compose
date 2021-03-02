package com.example.puppyadoption.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.puppyadoption.R
import com.example.puppyadoption.ui.theme.typography

@Composable
fun Place(name: String) {
    val color = R.color.white
    ChipView(gender = name, colorResource = colorResource(id = color))
}

@Composable
fun ChipView(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Text(
            text = gender, modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = typography.body2,
            color = Color.Black
        )
    }
}
