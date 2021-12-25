package com.example.currytime.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.currytime.screens.dashboardscreens.*
import com.example.currytime.screens.dashboardscreens.HomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {

        composable("onboarding") { OnBoardingScreen(navController) }
        composable("splash") { Splash(navController) }
        composable("Login") { Loginscreen(navController) }
        composable("Register") { Registerscreen(navController) }
//        dashboard
        composable("Dashboard") { DashboardView(navController) }
//        dashboar screens
        composable("home") { Home(navController) }
        composable("profile") { Profile(navController) }
        composable("search") { Search(navController) }
        composable("notifications") { Notifications(navController) }

    }


}