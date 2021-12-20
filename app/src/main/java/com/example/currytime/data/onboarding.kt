package com.example.currytime.data

import com.example.currytime.R

data class onboarding( val image: Int,
                       val title: String,
                       val desc: String
)

val onBoardItem = listOf(
    onboarding(
        R.drawable.nav1,
        "FIND THE FOOD YOU LOVE",
        "Discover the best healthy, tasty food\n" +
                "                and fast delivery to your doorsteps"

    ),
    onboarding(
        R.drawable.nav2,
        "FAST DELIVERY",
        "Fast food delivery to home,office\n" +
                "                wherever you are"
    ),
    onboarding(
        R.drawable.nav3,
        "LIVE TRACKING",
        "Real time tracking of your food\n" +
                "            once you placed the order"
    )



)