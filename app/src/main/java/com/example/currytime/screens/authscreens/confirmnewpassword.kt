package com.example.currytime.screens.authscreens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.currytime.R
import com.example.currytime.screens.boldRegisterFont
import com.example.currytime.screens.loginFont
import com.example.currytime.screens.maxCharEmail
import com.example.currytime.screens.semiloginFont
import com.example.currytime.ui.theme.dvgreenbtnbg
import com.example.currytime.ui.theme.dvgreentxt
import com.example.currytime.ui.theme.empasscolor



@Preview
@Composable
fun Confirmnewpaswordscreenview(){
    val navController = rememberNavController()
    Confirmnewpaswordscreen(navController)
}

//@Preview
@Composable
fun Confirmnewpaswordscreen(navController: NavController) {
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
                    text = "Confirm Password",
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
                MyNewPasswordTextField()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                MyConfirmNewPasswordTextField()
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                Spacer(modifier = Modifier.padding(0.dp, 5.dp))
                LoginButton(navController)



            }
        }
    }
}


//@Preview
@Composable
fun MyNewPasswordTextField() {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(

        modifier = Modifier.padding(horizontal = 0.dp),
        maxLines = 1,
        singleLine = true,
        label = {
            Text(
                text = stringResource(
                    id =
                    R.string.newpassword
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
fun MyConfirmNewPasswordTextField() {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(

        modifier = Modifier.padding(horizontal = 0.dp),
        maxLines = 1,
        singleLine = true,
        label = {
            Text(
                text = stringResource(
                    id =
                    R.string.confirmpassword
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
fun LoginButton(navController:NavController) {
    Button(
        onClick = {
            navController.navigate("Login")
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
            text = "Confirm Password",
            color = Color.White,
            fontFamily = loginFont,
            fontSize = 18.sp

        )
    }
}

