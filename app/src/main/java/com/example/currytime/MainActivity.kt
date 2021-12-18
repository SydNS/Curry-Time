package com.example.currytime

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currytime.ui.theme.CurryTimeTheme
import com.example.currytime.ui.theme.bgcolor
import com.example.currytime.ui.theme.bgcolor2
import com.example.currytime.ui.theme.dvgreentxt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurryTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Preview
@Composable
fun Splash() {
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
                    .align(alignment = CenterHorizontally)
                    .padding(start=30.dp, top =10.dp, end = 30.dp, bottom = 30.dp)

            ) {
                Image(
                    painterResource(id = R.drawable.logo), contentDescription = "logo",
                    modifier = Modifier
                        .align(alignment = CenterHorizontally)
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
                        .align(alignment = CenterHorizontally),
                    contentScale = ContentScale.FillBounds
                )

//            }
        }
    }

}

val imgcolor = Color(0xFF2B3141)
val titleFont = FontFamily(Font(R.font.oleoscriptbold))
