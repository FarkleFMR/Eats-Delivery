package com.example.eats

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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

class TarjetaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uitarjeta()
        }
    }
}


@Composable
fun Uitarjeta(){
    var numtar by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var ccv by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var año by remember { mutableStateOf("") }
    val context = LocalContext.current


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        Image(modifier = Modifier.size(150.dp,150.dp),
            painter = painterResource(id = R.drawable.creditcardicon),
            contentDescription = "Icono de tarjetas de credito",
            contentScale = ContentScale.Inside)
        TextField(value = numtar,
            onValueChange ={numerotarjeta -> numtar=numerotarjeta},
            label = {
                Text("Número de tarjeta")
            })
        TextField(value = nombre,
            onValueChange ={tarhabitante -> nombre = tarhabitante},
            label = {
                Text("Tarjeta habitante")
            })
        TextField(value = ccv,
            onValueChange ={codigo -> ccv = codigo},
            label = {
                Text("CCV")
            })
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text("Fecha de expiración:")
            TextField(modifier = Modifier.size(70.dp,50.dp),
                value = mes,
                onValueChange = {m -> mes = m},
                label = {
                    Text("Mes")
                })
            Text("/",style = TextStyle(fontSize = 40.sp))
            TextField(modifier = Modifier.size(70.dp,50.dp),
                value = año,
                onValueChange = {a -> año = a},
                label = {
                    Text("Año")
                })
        }
        Button(onClick = {context.startActivity(Intent(context,RegisterActivity::class.java))},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)) {
            Text("Aceptar",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}


@Preview
@Composable
fun previewTarjeta(){
    Uitarjeta()
}