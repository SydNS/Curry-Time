package com.example.currytime.screens.dashboardscreens


import BottomNavigationBar
import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.currytime.ui.theme.Typography
import com.example.currytime.R
import com.example.currytime.screens.Bottom_Route_Navigation
import com.example.currytime.ui.theme.dvgreenbtnbg
import com.example.currytime.ui.theme.dvgreentxt
import com.example.currytime.ui.theme.dvgreentxtbg
import com.google.accompanist.pager.ExperimentalPagerApi


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

//val imgcolor = Color(0xFF2B3141)
val homefont = FontFamily(Font(R.font.poppinsregular))


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = dvgreenbtnbg,
                contentColor = Color.White,
                elevation = 12.dp,
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Icon(
                            Icons.Outlined.LocationOn,
                            contentDescription = "Location",
                            tint = dvgreenbtnbg,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Pick Location",
                            fontFamily = homefont,
                            fontSize = 16.sp
                        )

                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Outlined.Person,
                            contentDescription = "Profile"
                        )
                    }
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Floating Button",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(25.dp)

                    )
                },

                )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                backgroundColor = dvgreenbtnbg,
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    Icons.Outlined.Add,
                    contentDescription = "Profile"
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Bottom_Route_Navigation(navController)
    }
}

