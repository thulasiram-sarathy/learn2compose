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
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.puppyadoption.data.LocalApi.PuppyRawApi
import com.example.puppyadoption.data.LocalApi.PuppyRawApi.getPuppyRawApi
import com.example.puppyadoption.navigation.NavigationScreen

@Composable
fun PuppyMain(toggleTheme: () -> Unit,context: Context) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationScreen.Home.route) {
        composable(NavigationScreen.Home.route) {
            Home(navController, getPuppyRawApi(context)!!, toggleTheme)
        }
        composable(
            "${NavigationScreen.Details.route}/{id}/{title}/{location}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            PuppyDetail(navController, it.arguments?.getInt("id") ?: 0,context)
        }
    }
}
