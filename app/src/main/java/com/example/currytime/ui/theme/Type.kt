package com.example.currytime.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
//    */
//    , h1 = TextStyle(
//        fontWeight = FontWeight.Light,
//        fontSize = 96.sp,
//        letterSpacing = (-1.5).sp
//    ),
//    h2 = TextStyle(
//        fontWeight = FontWeight.Light,
//        fontSize = 60.sp,
//        letterSpacing = (-0.5).sp
//    ),
//    h3 = TextStyle(
//        fontWeight = FontWeight.Normal,
//        fontSize = 48.sp,
//        letterSpacing = 0.sp
//    )
)