package com.example.currytime.screens


import android.content.Context
import android.widget.Toast
import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.currytime.R
import com.example.currytime.data.DataStoreManager
import com.example.currytime.data.onBoardItem
import com.example.currytime.ui.theme.Typography
import com.example.currytime.ui.theme.dvgreenbtnbg

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList


var poppinsonboarding= FontFamily(Font(R.font.poppinsthin, FontWeight.Light))

lateinit var ctx:Context

@ExperimentalPagerApi
//@Preview
@Composable
fun OnBoardingScreen(
    navController: NavController
) {

    val items = onBoardItem

    ctx=LocalContext.current
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0,
    )

    val cavdreams = FontFamily(Font(R.font.poppinsregular, FontWeight.Light))
    val cavdreamsdesc = FontFamily(Font(R.font.poppinsregular, FontWeight.SemiBold))

    Box(modifier = Modifier.padding(bottom = 10.dp).fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(top = 0.dp)
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .height(400.dp)
                    ) {
                        Image(
                            painter = painterResource(id = items[page].image),
                            contentDescription = items[page].title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )

                    }

                    PagerIndicator(items.size, pagerState.currentPage)

                    Text(
                        text = items[page].title,
                        modifier = Modifier.padding(top = 10.dp), color = Color.Black,
                        style = Typography.h4,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontFamily = cavdreams

                    )

                    Text(
                        text = items[page].desc,
                        modifier = Modifier.padding(top = 30.dp, start = 10.dp, end = 10.dp,bottom = 20.dp),
                        color = Color.Black,
                        style = Typography.h5,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = cavdreamsdesc

                    )

                }
            }

        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)
            .padding(bottom = 20.dp)) {
            BottomSection(pagerState.currentPage, navController,pagerState,ctx)
        }
    }
}

//this function was never used becoze theres a similar in the sdk

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(

        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 30.dp)

    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}



@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) dvgreenbtnbg else Color.DarkGray.copy(alpha = 0.5f)
            )
    )
}

@ExperimentalPagerApi
@Composable
fun BottomSection(currentPager: Int, navController: NavController,pagerState:PagerState,context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom=10.dp),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {

        var dataStoreManager = DataStoreManager(context )

        if (currentPager == 2) {
            Button(
                onClick = {
                    GlobalScope.launch(Dispatchers.IO) {
                        dataStoreManager.saveToDatastore("Old")
                    }
                    navController.popBackStack()
                    navController.navigate("Login")
                },
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =dvgreenbtnbg
                ),
                shape = RoundedCornerShape(50), // = 40% percent
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light
                )
            }
        } else if (currentPager == 0) {

            SkipNextButton("", Modifier.padding(end = 20.dp))
            SkipNextButton(
                "Next",
                Modifier
                    .padding(end = 20.dp)
                    .clickable(enabled = true, onClick = {
//                        pagerState.targetPage==2
                    })
            )
        } else {
            SkipNextButton("Prev", Modifier.padding(start = 20.dp))
            SkipNextButton("Next", Modifier.padding(end = 20.dp))
        }

    }
}

@Composable
fun SkipNextButton(text: String, modifier: Modifier) {
    Text(
        text = text, color = dvgreenbtnbg,
        modifier = modifier, fontSize = 25.sp,
        style = Typography.body1,
        fontWeight = FontWeight.Light
    )

}

@Preview
@Composable
fun Skipnxtview(){
//    SkipNextButton("Skip",
//        Modifier.background(Color.Green)
//        .size(100.dp,50.dp))
    val navController = rememberNavController()

//    BottomSection(1, navController.)


}