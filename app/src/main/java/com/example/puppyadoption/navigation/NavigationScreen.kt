package com.example.puppyadoption.navigation

import androidx.annotation.StringRes
import com.example.puppyadoption.R

sealed class NavigationScreen(val route: String, @StringRes val resourceId: Int) {
    object Home : NavigationScreen("home", R.string.home)
    object Details : NavigationScreen("details", R.string.detail)
}
