package com.example.currytime.screens.authscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currytime.R
import com.example.currytime.screens.boldRegisterFont
import com.example.currytime.screens.semiloginFont
import com.example.currytime.ui.theme.dvgreentxt
import com.example.currytime.ui.theme.dvgreentxtbg


@Preview
@Composable
fun Otpscreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center)
                .background(Color.Transparent)
        ) {

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .background(color = Color.Transparent)
                    .align(alignment = Alignment.CenterHorizontally)

            ) {
                Image(
                    painterResource(id = R.drawable.logo), contentDescription = "logo",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .height(150.dp)
                        .width(150.dp)
                )
                Text(
                    color = dvgreentxt,
                    text = "We have sent an OTP to your Phone",
                    fontWeight = FontWeight.Light,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = boldRegisterFont,
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)


                )
            }
//            var text by rememberSaveable { mutableStateOf("Text") }

//            var text by remember { mutableStateOf("text") }
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(horizontal = 40.dp)
                    .background(Color.Transparent)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {

                Otprow()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
//                forgotpass()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                ResetpasswordButton()
                Spacer(modifier = Modifier.padding(0.dp, 30.dp))
                Didntrecievethecode()


            }
        }
    }
}


//@Preview
@Composable
fun Otprow(){
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.padding(horizontal = 10.dp)){
        OtpChat()
        Spacer(modifier = Modifier.padding(10.dp, 0.dp))
        OtpChat()
        Spacer(modifier = Modifier.padding(10.dp, 0.dp))
        OtpChat()
        Spacer(modifier = Modifier.padding(10.dp, 0.dp))
        OtpChat()
    }
}

//@Preview
@Composable
fun OtpChat(){
    var text by remember { mutableStateOf("1") }
    val maxChar = 1

    Column(modifier = Modifier.background(dvgreentxtbg)
        .clip(shape = RoundedCornerShape(25.dp))
        .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value =text,
            onValueChange = {if (it.length <= maxChar) text = it},
            modifier = Modifier.width(40.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 20.sp,
                textAlign= TextAlign.Center),
            colors= TextFieldDefaults.textFieldColors(
                textColor = dvgreentxt,
                backgroundColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                focusedIndicatorColor = Transparent)
        )
        Divider(Modifier
            .width(28.dp)
            .padding(bottom = 2.dp)
            .offset(y=-10.dp),
            color = White,
            thickness = 1.dp)
    }
}


//@Preview
@Composable
fun Didntrecievethecode() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .wrapContentHeight()
    )
    {
        Row(
            modifier = Modifier
                .width(260.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {

            Text(
                modifier = Modifier
                    .padding(5.dp, 5.dp),
                text = "Didn't recieve",
                style = TextStyle(
//            color = dvgreentxt,
                    fontFamily = semiloginFont,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 5.dp)
                    .clickable(enabled = true, onClick = {
//                        navController.navigate("Login")
                    }),
                text = "Click here",
                style = TextStyle(
//            color = dvgreentxt,
                    fontFamily = semiloginFont,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            )

        }

    }
}