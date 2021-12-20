package com.example.currytime.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi


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


    }


}