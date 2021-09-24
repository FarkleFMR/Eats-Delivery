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

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uilogin()
        }
    }
}

@Composable
fun Uilogin(){
    val context = LocalContext.current
    var correo by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.SpaceEvenly){
        Image(modifier = Modifier.size(150.dp,150.dp) ,
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            contentScale = ContentScale.Inside)
        Row(verticalAlignment = Alignment.CenterVertically){
            Button(onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)) {
                Text("Log in",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp)
                )

            }
            Button(onClick = {context.startActivity(Intent(context,RegisterActivity::class.java))},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)) {
                Text("Registrarse",
                    style = TextStyle(fontSize = 20.sp)
                )

            }
        }
        TextField(value = correo,
            onValueChange = {NuevoCorreo -> correo = NuevoCorreo},
            label = {
                Text("Correo Electronico")
            })
        TextField(value = pass,
            onValueChange = {contraseña -> pass = contraseña},
            label = {
                Text("Contraseña")
            })
        Button(onClick = { context.startActivity(Intent(context,MenuActivity::class.java))},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)) {
            Text("Ingresar",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )

        }
    }
}

@Preview
@Composable
fun previewLogin(){
    Uilogin()
}