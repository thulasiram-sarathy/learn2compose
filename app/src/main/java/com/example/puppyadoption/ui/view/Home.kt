package com.example.puppyadoption.ui.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.puppyadoption.model.PuppyData

@Composable
fun Home(navController: NavHostController, puppyList: List<PuppyData>, toggleTheme: () -> Unit) {
    LazyColumn {
        item {
            TopBar(
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(puppyList) {
                ItemDogCard(
                    it,
                    onItemClicked = { dog ->
                        navController.navigate("details/${dog.id}//${dog.name}/${dog.gender}")
                    }
                )
        }
    }
}
