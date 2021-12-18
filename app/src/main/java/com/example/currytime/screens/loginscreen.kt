package com.example.currytime.screens

import android.text.method.TextKeyListener
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.example.currytime.R
import com.example.currytime.ui.theme.bgcolor
import com.example.currytime.ui.theme.bgcolor2
import com.example.currytime.ui.theme.dvgreenbtnbg
import com.example.currytime.ui.theme.dvgreentxt
import com.google.android.material.textfield.TextInputEditText






val imgcolor = Color(0xFF2B3141)
//ui custom fonts
val loginFont = FontFamily(Font(R.font.poppins))
val boldloginFont = FontFamily(Font(R.font.poppinsbold))
val semiloginFont = FontFamily(Font(R.font.poppinssemibold))

@Preview
@Composable
fun Loginscreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .background(color = Color.Transparent)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 30.dp)

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
                    text = "Login",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = loginFont,
                    modifier = Modifier
                        .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)


                )
            }
//            var text by rememberSaveable { mutableStateOf("Text") }

//            var text by remember { mutableStateOf("text") }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = CenterHorizontally)
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                MyTextField()
                Spacer(modifier = Modifier.padding(0.dp, 10.dp))
                MyTextField()
                Spacer(modifier = Modifier.padding(0.dp, 10.dp))
                forgotpass()
                Spacer(modifier = Modifier.padding(0.dp, 10.dp))
                LoginButton()


            }
        }
    }
}

@Preview
@Composable
fun MyTextField() {
    val textValue = remember { mutableStateOf("") }
    val primaryColor = colorResource(id = R.color.colorPrimary)
    OutlinedTextField(
        modifier = Modifier.padding(horizontal = 40.dp),
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
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType
            = KeyboardType.Email
        ),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
    )
}

@Preview
@Composable
fun forgotpass() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        text = "Forgot your password ?",
        style = TextStyle(
//            color = dvgreentxt,
            fontFamily = loginFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    )
}

@Preview
@Composable
fun LoginButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .background(color = dvgreenbtnbg)
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontFamily = loginFont,
            fontSize = 20.sp

        )
    }
}

@Preview
@Composable
fun SocialAuth(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()){
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = com.example.currytime.R.drawable.facebook),
                "facebook",
                Modifier.padding(start = 20.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Forgot your password ?",
                style = TextStyle(
//            color = dvgreentxt,
                    fontFamily = loginFont,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            
        }

    }
}