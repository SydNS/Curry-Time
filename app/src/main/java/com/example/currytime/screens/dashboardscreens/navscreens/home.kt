package com.example.currytime.screens.dashboardscreens.navscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currytime.R
import com.example.currytime.ui.theme.Typography
import com.example.currytime.ui.theme.dvgreenbtnbg
import com.example.currytime.ui.theme.dvgreentxt
import com.example.currytime.ui.theme.dvgreentxtbg


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
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

        }


    }
}

@Composable
fun Chipsection(chips: List<String>) {
    var selectedChiIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .width(200.dp)
                    .height(100.dp)
                    .clickable { selectedChiIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(
                        if (selectedChiIndex == it) dvgreentxtbg
                        else dvgreenbtnbg

                    ),
            ) {
                Text(text = chips[it], color = dvgreentxt)

            }
        }
    }

}

var chiplist =
    listOf<String>("sydn", "sydn", "sydn", "sydn", "sydn", "sydn", "sydn", "sydn", "sydn")

@Preview
@Composable
fun Chips() {
    Chipsection(chips = chiplist)
}


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Home View",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
