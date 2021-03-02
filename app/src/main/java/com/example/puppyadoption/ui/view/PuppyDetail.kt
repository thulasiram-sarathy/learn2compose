/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.puppyadoption.ui.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.navigation.NavController
import com.example.puppyadoption.R
import com.example.puppyadoption.data.LocalApi.PuppyRawApi
import com.example.puppyadoption.ui.theme.blue1
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlin.math.max
import kotlin.math.min

@Composable
fun PuppyDetail(navController: NavController, id: Int, context: Context) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(PuppyRawApi.getPuppyDetail(context,id)!!.name!!) },
                backgroundColor = Color.White,
                contentColor = colorResource(id = R.color.text),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = colorResource(id = R.color.text)
                    )
                }
            )
        },

        content = {
            DetailsView(id,context)
        }
    )
}

@Composable
fun DetailsView(id: Int, context: Context) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if(isSystemInDarkTheme()) blue1 else Color.White)
    ) {

//        val dog = FakeDogDatabase.dogList[id]
        val dog = PuppyRawApi.getPuppyDetail(context,id)!!

        // Basic details
        item {
            dog.apply {
                NetworkImage(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(16.dp)),
                        .clip(CircleShape),
                    url = dog.hdurl!!,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))
                DogInfoCard(name!!, gender!!, place!!)
            }
        }

        // My story details
        item {
            dog.apply {

                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "About Me")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = aboutme!!,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    color = colorResource(id = R.color.text),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start
                )
            }
        }

        // Quick info
        item {
            dog.apply {

                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "My info")
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoCard(title = "Age", value = dog.age.toString().plus(" yrs"))
                    InfoCard(title = "Place", value = dog.place!!)
                    InfoCard(title = "Weight", value = weight.toString())
                }
            }
        }



    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = colorResource(id = R.color.text),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}

