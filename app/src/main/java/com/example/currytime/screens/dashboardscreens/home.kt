package com.example.currytime.screens.dashboardscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Green)){

    }
}

@Composable
fun Profile(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Red)){

    }
}

@Composable
fun Search(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Blue)) {

    }
}

@Composable
fun Notifications(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Yellow)) {

    }
}
