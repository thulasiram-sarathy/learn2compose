package com.example.puppyadoption.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.puppyadoption.R
import com.example.puppyadoption.ui.theme.blue1
import com.example.puppyadoption.ui.theme.teal200
import com.example.puppyadoption.ui.theme.typography

@Composable
fun TopBar(onToggle: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Bow Wow,",
                textAlign = TextAlign.Start,
//                style = MaterialTheme.typography.h5,
                style = typography.h5,
//                color = MaterialTheme.colors.surface
                color = if(isSystemInDarkTheme()) Color.White else Color.Black
            )

            /*Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Adopt a new friend near you!",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.surface
            )*/
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 36.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            ThemeChange(onToggle = { onToggle() })
        }
    }
}

@Composable
fun ThemeChange(onToggle: () -> Unit) {

    val icon = if (isSystemInDarkTheme())
        painterResource(id = R.drawable.ic_daymode_off)
    else
        painterResource(id = R.drawable.ic_light_on)

    Icon(
        painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(24.dp, 24.dp)
            .clickable(onClick = onToggle),
//        tint = colorResource(id = R.color.text)
    )
}
