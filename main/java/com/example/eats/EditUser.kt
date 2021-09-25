package com.example.eats

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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

class EditUser : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UieditUser()
        }
    }
}

@Composable
fun UieditUser(){
    val context = LocalContext.current
    var correo by remember { mutableStateOf("") }
    var dir by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.SpaceEvenly){
        Icon(modifier = Modifier.size(100.dp,100.dp),
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Icono de usuario",
            tint = Color.Black)
        TextField(value = correo,
            onValueChange = {NuevoCorreo -> correo = NuevoCorreo},
            label = {
                Text("jenaromurilloaldecoba@gmail.com")
            })
        TextField(modifier = Modifier.height(100.dp).width(280.dp),
            value = dir,
            onValueChange = {direc -> dir = direc},
            label = {
                Text("Dirección para entrega")
            })
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(modifier = Modifier.size(60.dp,60.dp),
                painter = painterResource(id = R.drawable.creditcardicon),
                contentDescription = "Icono de tarjetas de credito",
                contentScale = ContentScale.Inside)
            Button(onClick = {context.startActivity(Intent(context,TarjetaActivity::class.java))},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .height(55.dp)
                    .width(220.dp)) {
                Text("Ingresar tarjeta",
                    style = TextStyle(fontSize = 20.sp)
                )

            }
        }

        Button(onClick = {context.startActivity(Intent(context,UserInfoActivity::class.java))},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)) {
            Text("Actualizar",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )

        }
    }
}

@Preview
@Composable
fun previewEditUser(){
    UieditUser()
}