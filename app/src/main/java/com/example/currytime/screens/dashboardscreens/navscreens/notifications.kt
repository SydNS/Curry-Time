import android.text.Html
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.currytime.R
import com.example.currytime.screens.dashboardscreens.navscreens.poppinsBold
import com.example.currytime.screens.dashboardscreens.navscreens.poppinsLight
import com.example.currytime.ui.theme.orange


@Composable
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
            .wrapContentSize(Alignment.Center)
    ) {
        
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    NotificationScreen()
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
                selectedItem(index + 1)
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


