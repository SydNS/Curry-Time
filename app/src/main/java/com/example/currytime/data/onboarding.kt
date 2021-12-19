package com.example.currytime.data

import com.example.currytime.R

data class onboarding( val image: Int,
                       val title: String,
                       val desc: String
)

val onBoardItem = listOf(
    onboarding(
        R.drawable.logo,
        "Make it Easy One",
        "Lorem Ipsum is simply dummy text of the printing and typesetting Industry."
    ),
    onboarding(
        R.drawable.facebook,
        "Make it Easy Two",
        "Lorem Ipsum is simply dummy text of the printing and typesetting Industry."
    ),
    onboarding(
        R.drawable.logo,
        "Make it Easy Three",
        "Lorem Ipsum is simply dummy text of the printing and typesetting Industry."
    )
)