package com.example.currytime.screens.dashboardscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.currytime.ui.theme.Typography
import com.example.currytime.R

@Composable
fun Homescreen() {

}

@Composable
fun GreetingSection(name: String = "Divya") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning $name", style = Typography.h2
            )
            Text(
                text = "Thank You For Choosing Us", style = Typography.body1
            )
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Search",
            tint= Color.White,
            modifier = Modifier.size(24.dp))

        }



    }
}

@Composable
