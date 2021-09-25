package com.example.eats

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

class UserInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            UserInfoUI()
        }
    }

}


@Composable
fun UserInfoUI(){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.background)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillHeight
        )

    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){
        Icon(modifier = Modifier.size(100.dp,100.dp),
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Icono de usuario",
            tint = Color.Black)
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = "Jenaro Murillo")
            IconButton(onClick = {context.startActivity(Intent(context,EditUser::class.java))}) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Icono de editar",
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            onClick = {context.startActivity(Intent(context, HistorialActivity::class.java))}) {
            Text(text = "Ordenes",
                color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            onClick = {  }) {
            Text("FAQ",
                color = Color.White)
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


}


@Preview
@Composable
fun previewUserInfo(){
    UserInfoUI()
}