package com.example.eats

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eats.ui.theme.EatsTheme

class HistorialActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            HistorialUI()
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun HistorialUI() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillHeight
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Historial",
            style = TextStyle(fontSize = 30.sp))
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(75.dp, 100.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Orden"
                )
                Column {
                    Text(
                        "Mex-Eat",
                        style = TextStyle(fontSize = 30.sp)
                    )
                    Text(
                        "Tejar el Guarco",
                        style = TextStyle(fontSize = 15.sp)
                    )
                }
                Text("7000")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(75.dp, 100.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Orden"
                )
                Column {
                    Text(
                        "Mex-Eat",
                        style = TextStyle(fontSize = 30.sp)
                    )
                    Text(
                        "Tejar el Guarco",
                        style = TextStyle(fontSize = 15.sp)
                    )
                }
                Text("7000")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(75.dp, 100.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Orden"
                )
                Column {
                    Text(
                        "Mex-Eat",
                        style = TextStyle(fontSize = 30.sp)
                    )
                    Text(
                        "Tejar el Guarco",
                        style = TextStyle(fontSize = 15.sp)
                    )
                }
                Text("7000")
            }
        }
    }
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom){
        IconButton(onClick = { context.startActivity(Intent(context,MenuActivity::class.java))}) {
            Icon(
                Icons.Filled.Home,
                "Buton al menu",
                tint = Color.White
            )
        }
    }
}



@ExperimentalMaterialApi
@Preview
@Composable
fun previewHistorial(){
    HistorialUI()
}