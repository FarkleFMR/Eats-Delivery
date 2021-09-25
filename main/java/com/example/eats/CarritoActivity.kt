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
import androidx.compose.material.icons.filled.Delete
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

class CarritoActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            CarritoUI()
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun CarritoUI() {
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
        Text(text = "Carrito",
            style = TextStyle(fontSize = 30.sp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(75.dp, 100.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Orden"
                )
                Column {
                    Text(
                        "Tacos al pastor",
                        style = TextStyle(fontSize = 30.sp)
                    )
                    Text(
                        "Instrucciones",
                        style = TextStyle(fontSize = 15.sp)
                    )
                }
                Text("3000")
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Delete,
                    "Borrar el producto",
                    tint = Color.Red)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(75.dp, 100.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Orden"
                )
                Column {
                    Text(
                        "Chimichanga",
                        style = TextStyle(fontSize = 30.sp)
                    )
                    Text(
                        "Ingredientes",
                        style = TextStyle(fontSize = 15.sp)
                    )
                }

                Text("2700")
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Delete,
                        "Borrar el producto",
                        tint = Color.Red)
                }
            }
        }
        Text("Total....................5700",
        style = TextStyle(fontSize = 35.sp))
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            Text(
                modifier = Modifier
                    .height(100.dp)
                    .width(280.dp),
                text = "Condominio nobleza de Coris",
                style = TextStyle(fontSize = 30.sp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Edit,
                    "Editar direccion",
                    tint = Color.Black)
            }
        }
        Button(onClick = {context.startActivity(Intent(context,MenuActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)) {
            Text("Pagar",
                color = Color.Red,
                style = TextStyle(fontSize = 20.sp)
            )
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
fun previewCarrito(){
    CarritoUI()
}