package com.example.puppyadoption.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.puppyadoption.R
import com.example.puppyadoption.model.PuppyData
import com.example.puppyadoption.ui.theme.*

@Composable
fun ItemDogCard(dog: PuppyData, onItemClicked: (dog: PuppyData) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(dog) }),
        elevation = 0.dp,
//        backgroundColor = MaterialTheme.colors.onSurface
        backgroundColor = if (isSystemInDarkTheme()) blue2 else orange
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            /*val image: Painter = painterResource(id = R.drawable.dog_eight)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )*/
            NetworkImage(
                url = dog.hdurl!!,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = dog.name!!,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = /*if (isSystemInDarkTheme())*/ Color.White, /*else orange,*/
                    fontWeight = FontWeight.Bold,
                    style = typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = buildString {
                        append(dog.age)
                        append("yrs - ")
                        append(dog.gender)
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = Color.White,
                    style = typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    val weight: Painter = painterResource(id = R.drawable.ic_weight_scale)

                    Icon(
                        painter = weight,
                        contentDescription = null,
                        modifier = Modifier.size(12.dp, 12.dp),
                        tint = Color.White
                    )

                    Text(
                        text = dog.age!! + " kgs",
                        modifier = Modifier.padding(8.dp, 9.dp, 12.dp, 0.dp),
                        color = Color.White,
                        style = typography.caption
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Place(dog.place!!)
            }
        }
    }
}
