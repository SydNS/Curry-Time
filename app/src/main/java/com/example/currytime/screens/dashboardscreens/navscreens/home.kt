package com.example.currytime.screens.dashboardscreens.navscreens

import android.text.Html
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.currytime.R
import com.example.currytime.ui.theme.*


@Composable
fun GreetingSection(name: String = "Divya") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Hello $name", style = Typography.h3, fontWeight = FontWeight.Light
            )
            Text(
                text = "Thank You For Choosing Us", style = Typography.body1
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

        }


    }
}

@Preview
@Composable
fun GreetingSectionView() {
    GreetingSection("Sydney")
}


@Composable
fun Chipsection(chips: List<String>) {
    var selectedChiIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .width(200.dp)
                    .height(100.dp)
                    .clickable { selectedChiIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(
                        if (selectedChiIndex == it) dvgreentxtbg
                        else dvgreenbtnbg

                    ),
            ) {
                Text(text = chips[it], color = dvgreentxt)

            }
        }
    }

}

var chiplist =
    listOf<String>("sydn", "sydn", "sydn", "sydn", "sydn", "sydn", "sydn", "sydn", "sydn")

@Preview
@Composable
fun Chips() {
    Chipsection(chips = chiplist)
}


val poppinsBold = Font(R.font.poppinsbold)
val poppinsLight = Font(R.font.poppinsregular)

@Composable
fun HomeScreen(navController: NavController,selectedItem:(Int)->Unit) {

    val scrollState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            GreetingSection("Sydney")
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                backgroundColor = Color.White,
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.4f)
                            .fillMaxWidth()
                    ) {
                        AndroidView(
                            factory = { context ->
                                TextView(context).apply {
                                    text =
                                        Html.fromHtml("<string><big><b><span style = \"color:#000000\">The Fastest In Delivery </span><span style = \"color:#F54748\">Food</span></b></big></string>")
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .width(100.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            colors = ButtonDefaults.buttonColors(orange)
                        ) {
                            Text(
                                text = "Order Now",
                                fontFamily = FontFamily(poppinsBold),
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.6f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.delivery_image),
                            contentDescription = "Delivery Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }

        item {
            Text(
                text = "Categories",
                fontFamily = FontFamily(poppinsBold),
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))
        }

        item {

            LazyRow {
                items(10) { index ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(
                                if (index == 0) orange else dvgreenbtnbg
                            )
                            .wrapContentWidth()
                            .padding(end = 15.dp, start = 15.dp, top = 10.dp, bottom = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    id = when (index) {
                                        0 -> R.drawable.burger
                                        1 -> R.drawable.pizza
                                        else -> R.drawable.burger
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = when (index) {
                                0 -> "Burger"
                                1 -> "Pizza"
                                2 -> "Sandwich"
                                else -> "Toast"
                            },
                            fontFamily = FontFamily(poppinsLight),
                            color = if (index == 0) Color.White else Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
        item {
            Row(
                modifier = Modifier.padding(end = 25.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Popular Now",
                        fontFamily = FontFamily(poppinsBold),
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "View All",
                                fontFamily = FontFamily(poppinsLight),
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_arrow_circle_right_24),
                                contentDescription = "view all Image",
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(Color.Black)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
        item {

            LazyRow {
                items(10) { index ->
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .wrapContentHeight()
                            .padding(start = 5.dp),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 20.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (index % 2 == 0) {
                                        R.drawable.burger
                                    } else {
                                        R.drawable.double_burger
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(120.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = when (index) {
                                    0 -> "Beef Burger"
                                    1 -> "Double Burger"
                                    else -> "Cheese Burger"
                                },
                                fontFamily = FontFamily(poppinsBold),
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = when (index) {
                                        0 -> "Cheesy"
                                        1 -> "Beef"
                                        else -> "Chilli"
                                    },
                                    fontFamily = FontFamily(poppinsLight),
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Image(
                                    painter = painterResource(
                                        id = if (index % 2 == 0) {
                                            R.drawable.cheese
                                        } else {
                                            R.drawable.beef
                                        }
                                    ),
                                    contentDescription = "Category Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            AndroidView(
                                factory = { context ->
                                    TextView(context).apply {
                                        text = if (index % 2 == 0) {
                                            Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>14.10</big></big></span></b></string>")
                                        } else {
                                            Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>8.35</big></big></span></b></string>")
                                        }
                                    }
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

        }
        item {
            Text(
                text = "More Foods",
                fontFamily = FontFamily(poppinsBold),
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(20) { index ->
                VerticallistItem(index,selectedItem,navController)
                Spacer(modifier = Modifier.width(10.dp))

        }
        item {
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}

//@Preview(showBackground = true)
@Composable
fun VerticallistItem(index:Int,selectedItem:(Int)->Unit,navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp)
            .clickable {
                selectedItem(index+1)
                navController.navigate("Details")
            },
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.wrapContentHeight()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,

                ) {
                Image(
                    painter = painterResource(
                    id = if (index % 2 == 0) {
                        R.drawable.burger
                    } else {
                        R.drawable.burger
                    }
                    ),
                    contentDescription = "Category Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                )
                Spacer(modifier = Modifier.width(10.dp))

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxHeight()
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    text = when (index % 2) {
                        0 -> "Beef Burger"
                        1 -> "Double Burger"
                        else -> "Cheese Burger"
                    },
                    fontFamily = FontFamily(poppinsBold),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.wrapContentSize(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = when (index % 2) {
                            0 -> "Beef Burger"
                            1 -> "Double Burger"
                            else -> "Cheese Burger"
                        },
                        fontFamily = FontFamily(poppinsLight),
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(0.dp))
                    Image(
                        painter = painterResource(
                            id = if (index % 2 == 0) {
                                R.drawable.cheese
                            } else {
                                R.drawable.beef
                            }
                        ),
                        contentDescription = "Category Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.height(0.dp))
                AndroidView(
                    factory = { context ->
                        TextView(context).apply {
                            text = if (index % 2 == 0) {
                                Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>$index</big></big></span></b></string>")
                            } else {
                                Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>$index</big></big></span></b></string>")
                            }
                        }
                    }
                )

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    modifier = Modifier
                        .width(80.dp),
                    colors = ButtonDefaults . buttonColors (orange),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
                        contentDescription = "adding to cart",
                        tint = Color.White
                    )
                }

            }
        }
    }

}

@Preview
@Composable
fun VerticallistItemVIEW(){
//    VerticallistItem(2)
}