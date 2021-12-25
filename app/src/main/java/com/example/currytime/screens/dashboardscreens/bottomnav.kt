package com.example.currytime.screens.dashboardscreens

import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.currytime.R
import com.example.currytime.screens.Loginscreen
import com.example.currytime.screens.OnBoardingScreen
import com.example.currytime.screens.Registerscreen
import com.example.currytime.screens.Splash
import com.example.currytime.ui.theme.dvgreenbtnbg
import com.google.accompanist.pager.ExperimentalPagerApi

sealed class Screens(
    val title: String, val route: String, @DrawableRes val icons: Int
) {
    object Home : Screens(
        "Home",
        "home",
        R.drawable.ic_baseline_home_24
    )

    object Notifications : Screens(
        "Notifications",
        "notification",
        R.drawable.ic_baseline_notifications_24
    )

    object Search : Screens(
        "Search",
        "search",
        R.drawable.ic_baseline_search_24
    )

    object Profile : Screens(
        "Profile",
        "profile",
        R.drawable.ic_baseline_home_24
    )

}


//navigations

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun BottomNavBarNavigationHost() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
//        dashboar screens
//        composable("Dashboard") { DashboardView(navController) }

        composable("home") { Home(navController) }
        composable("profile") { Profile(navController) }
        composable("search") { Search(navController) }
        composable("notifications") { Notifications(navController) }

    }

}


//bottom nav view
@Composable
fun dashboardbottomnav(navController: NavController, items: List<Screens>) {

//    state of the bottomnavigtion
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation() {
        items.forEach { screens ->
            BottomNavigationItem(
                selected = currentDestination?.route == screens.route,
                onClick = {
                    navController.navigate(screens.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screens.icons),
                        contentDescription = null
                    )
                },
                label = { Text(text = screens.title) },
                alwaysShowLabel = false,

                )

        }

    }

}


@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun DashboardView(navController: NavController) {
    val listofscreens = listOf(
        Screens.Home,
        Screens.Search,
        Screens.Notifications,
        Screens.Profile
    )
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
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
                        Icons.Outlined.Person,
                        contentDescription = "Profile"
                    )
                }
            },
            isFloatingActionButtonDocked = true,
            floatingActionButtonPosition = FabPosition.Center,

            bottomBar = {
                dashboardbottomnav(navController, listofscreens)
            }) {
            BottomNavBarNavigationHost()
        }

    }
}
