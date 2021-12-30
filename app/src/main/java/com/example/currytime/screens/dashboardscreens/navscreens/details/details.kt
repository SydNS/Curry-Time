import android.app.Activity
import android.text.Html
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.currytime.R
import com.example.currytime.ui.theme.FoodBackgroundColor
import com.example.currytime.ui.theme.FoodColor


@Composable
fun RecipesScreen() {
    var value by remember { mutableStateOf(5) }
    val activity = LocalContext.current as Activity
    val poppins_bold = Font(R.font.poppinsbold)
    val poppins_medium = Font(R.font.poppinsregular)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FoodBackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .weight(0.28f)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .size(40.dp)
                            .clickable {
                                activity.onBackPressed()
                            }
                            .background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Back Arrow",
                            modifier = Modifier
                                .size(25.dp),
                            tint = Color.Black
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .size(40.dp)
                                .background(Color.White),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.two_dot),
                                contentDescription = "Menu",
                                modifier = Modifier
                                    .size(15.dp)
                                    .rotate(90f),
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(0.72f)
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                .background(Color.White)
        ) { }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(id = R.drawable.burger_img),
            contentDescription = "Category Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 220.dp, height = 300.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(FoodColor)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "Minus",
                modifier = Modifier
                    .clickable {
                        value--
                    }
                    .size(25.dp),
                tint = Color.White
            )
            Text(
                text = "$value",
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                style = TextStyle(
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_plusic_plus),
                contentDescription = "Add",
                modifier = Modifier
                    .clickable {
                        value++
                    }
                    .size(25.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(0.7f)
                ) {
                    Text(
                        text = "Beef Burger",
                        color = Color.Black,
                        style = TextStyle(
                            fontStyle = FontStyle.Normal,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Cheesy Mozarella",
                            color = Color.Gray,
                            style = TextStyle(
                                fontStyle = FontStyle.Normal,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.cheese),
                            contentDescription = "Category Image",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(0.3f)
                ) {
                    AndroidView(
                        factory = { context ->
                            TextView(context).apply {
                                text =
                                    Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>14.10</big></big></span></b></string>")
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.wrapContentSize()
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Rating",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "3.5",
                            color = Color.Black,
                            style = TextStyle(
                                fontStyle = FontStyle.Normal,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "Flame",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "150 Kcal",
                            color = Color.Black,
                            style = TextStyle(
                                fontStyle = FontStyle.Normal,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chronometer),
                            contentDescription = "Time",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            color = Color.Black,
                            text = "Add to Cart",
                            style = TextStyle(
                                fontStyle = FontStyle.Normal,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            AndroidView(
                factory = { context ->
                    TextView(context).apply {
                        text =
                            Html.fromHtml("<string><span style = \"color:#424242\">This beef burger uses 100% quality beef with sliced tomates, cucumbers, vegetables and onions... </span><span style = \"color:#F54748\">Read More</span></string>")
                    }
                }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(FoodColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .height(65.dp)
            ) {

                Text(
                    text = "Add to Cart",
                    color = Color.White,
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview
@Composable()
fun detailsview(){
    RecipesScreen()
}

















