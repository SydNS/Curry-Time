package com.example.currytime.screens.authscreens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.currytime.ui.theme.bgcolor
import com.example.currytime.ui.theme.bgcolor2
import com.example.currytime.ui.theme.dvgreentxt
import kotlinx.coroutines.delay
import com.example.currytime.R


//@Preview
@Composable
fun Splash(navController: NavHostController) {

    val scale= remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = true ){
        scale.animateTo(targetValue = 1f,animationSpec = tween(
            durationMillis =   500,
            easing={
                OvershootInterpolator(2f)
                    .getInterpolation(it)
            }
        ))
        delay(1000L)
        navController.popBackStack()
        navController.navigate("Auth")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        bgcolor,
                        bgcolor2
                    )
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .background(color = Color.Transparent)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(start=30.dp, top =10.dp, end = 30.dp, bottom = 30.dp)

            ) {
                Image(
                    painterResource(id = R.drawable.logo), contentDescription = "logo",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(0.dp, 50.dp, 0.dp, 0.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .height(190.dp)
                        .width(190.dp)
                )
                Text(

                    color = dvgreentxt,
                    text = "WELCOME",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = titleFont,
                    modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 0.dp)


                )
            }

//            Box(modifier = Modifier.fillMaxSize()
//
//
//                ){
            Image(painter = painterResource(id = R.drawable.imagesplash),
                contentDescription ="plate of food",
                modifier = Modifier.fillMaxSize()

                    .padding( top = 5.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                contentScale = ContentScale.FillBounds
            )

//            }
        }
    }

}

val imgcolor = Color(0xFF2B3141)
val titleFont = FontFamily(Font(R.font.oleoscriptbold))
