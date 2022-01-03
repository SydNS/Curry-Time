package com.example.currytime.screens



import Detailscreen
import FavoriteScreen
import NotificationScreen
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.currytime.screens.authscreens.Confirmnewpaswordscreen
import com.example.currytime.screens.authscreens.Otpscreen
import com.example.currytime.screens.authscreens.Resetpasswordscreen
import com.example.currytime.screens.authscreens.Splash
import com.example.currytime.screens.dashboardscreens.*
import com.example.currytime.screens.dashboardscreens.navscreens.HomeScreen
import com.example.currytime.screens.dashboardscreens.navscreens.ProfileScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash", route = "MainRoute") {

        composable("splash") { Splash(navController) }

        navigation(route="Auth", startDestination = "onboarding"){
            composable("onboarding") { OnBoardingScreen(navController) }
            composable("Login") { Loginscreen(navController) }
            composable("Register") { Registerscreen(navController) }
//          otp
            composable("Otpscreen") { Otpscreen(navController) }
//          forgot password
            composable("Resetpassword") { Resetpasswordscreen(navController) }
            composable("Confirmpassword") { Confirmnewpaswordscreen(navController) }
        }

        composable("Dashboard") { MainScreen() }


    }


}


@Composable
fun Bottom_Route_Navigation(navController: NavHostController) {
    val ctx= LocalContext.current
    NavHost(navController, startDestination = "HomeToDetails") {


        navigation(route="HomeToDetails", startDestination =  NavigationItem.Home.route){
            composable(NavigationItem.Home.route) {
                HomeScreen(navController) {
                    Toast.makeText(ctx, it.toString(), Toast.LENGTH_LONG).show()
                }
            }
            composable("Details") { Detailscreen() }

        }

        composable(NavigationItem.Notifications.route) {
            NotificationScreen()
        }
        composable(NavigationItem.Favorite.route) {
            FavoriteScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }


    }
}


@Composable
fun Detailscreen_Route_Navigation(navController: NavHostController) {
    var ctx= LocalContext.current
    NavHost(navController, startDestination = "Details", route = "Details") {

        composable ("Details") {
//            Detailscreen()
        }

    }
}