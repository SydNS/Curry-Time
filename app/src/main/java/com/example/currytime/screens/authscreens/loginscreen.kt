package com.example.currytime.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.currytime.R
import com.example.currytime.ui.theme.dvgreenbtnbg
import com.example.currytime.ui.theme.dvgreentxt
import com.example.currytime.ui.theme.empasscolor


//val imgcolor = Color(0xFF2B3141)

//ui custom fonts
val loginFont = FontFamily(Font(R.font.poppinsregular))
val boldloginFont = FontFamily(Font(R.font.poppinsbold))
val semiloginFont = FontFamily(Font(R.font.poppinssemibold))
val loginFontExtra = FontFamily(Font(R.font.poppinsextraligh))

var maxCharEmail: Int = 20

//@Preview
@Composable
fun Loginscreen(navController: NavHostController) {
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
                    text = "Login",
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
                MyTextField()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                MyPasswordTextField()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                forgotpass()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                LoginButton(navController)
                Spacer(modifier = Modifier.padding(0.dp, 30.dp))
                SocialAuthFacebook()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                SocialAuthGoogle()
                Spacer(modifier = Modifier.padding(top = 25.dp))
                NotaMember(navController)


            }
        }
    }
}


//@Preview


@Composable
fun MyTextField() {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(

        modifier = Modifier.padding(horizontal = 0.dp),
        maxLines = 1,
        singleLine = true,
        label = {
            Text(
                text = stringResource(
                    id =
                    R.string.email
                ),
                fontWeight = FontWeight.SemiBold
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = empasscolor,
            focusedLabelColor = empasscolor,
            cursorColor = empasscolor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType
            = KeyboardType.Email
        ),
        value = textValue.value,
        onValueChange = {
            if (it.length <= maxCharEmail) {
                textValue.value = it
            }
        },

        )
}

//@Preview
@Composable
fun MyPasswordTextField() {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(

        modifier = Modifier.padding(horizontal = 0.dp),
        maxLines = 1,
        singleLine = true,
        label = {
            Text(
                text = stringResource(
                    id =
                    R.string.password
                ),
                fontWeight = FontWeight.SemiBold
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = empasscolor,
            focusedLabelColor = empasscolor,
            cursorColor = empasscolor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType
            = KeyboardType.Email
        ),
        value = textValue.value,
        onValueChange = {
            if (it.length <= maxCharEmail) {
                textValue.value = it
            }
        },

        )
}

//@Preview
@Composable
fun forgotpass() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp),
        text = "Forgot your password ?",
        style = TextStyle(
//            color = dvgreentxt,
            fontFamily = semiloginFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    )
}

//@Preview
@Composable
fun LoginButton(navController:NavController) {
    Button(
        onClick = {
            navController.navigate("Dashboard")
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = dvgreenbtnbg,
            contentColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontFamily = loginFont,
            fontSize = 18.sp

        )
    }
}

//@Preview
@Composable
fun SocialAuthFacebook() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .width(260.dp)
                .align(alignment = CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                "facebook",
                Modifier
                    .padding(start = 20.dp, top = 5.dp, bottom = 5.dp)
                    .wrapContentHeight()
                    .size(20.dp), alignment = Center,
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 5.dp),
                text = "Sign In With Facebook",
                style = TextStyle(
//            color = dvgreentxt,
                    fontFamily = semiloginFont,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )

        }

    }
}


//@Preview
@Composable
fun SocialAuthGoogle() {
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
                .align(alignment = CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = com.example.currytime.R.drawable.google),
                "facebook",
                Modifier
                    .padding(start = 20.dp, top = 5.dp, bottom = 5.dp)
                    .wrapContentHeight()
                    .size(20.dp), alignment = Center,
                contentScale = ContentScale.Fit

            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 5.dp),
                text = "Sign In With Google",
                style = TextStyle(
//            color = dvgreentxt,
                    fontFamily = semiloginFont,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )

        }

    }
}


//@Preview
@Composable
fun NotaMember(navController: NavHostController) {

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier
                .padding(5.dp, 5.dp),
            text = "Not A Member?",
            style = TextStyle(
//            color = dvgreentxt,
                fontFamily = semiloginFont,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        Text(
            modifier = Modifier
                .padding(5.dp, 5.dp)
                .clickable(enabled = true, onClick = {
                    navController.navigate("Register")
                }),
            text = "Join Now",
            style = TextStyle(
                color = dvgreentxt,
                fontFamily = semiloginFont,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),

        )

    }

}

