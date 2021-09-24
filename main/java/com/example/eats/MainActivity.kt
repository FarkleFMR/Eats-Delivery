package com.example.eats

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Mycomponent()
        }
    }

}



@Composable
fun Mytext(text:String){
    Text(text,
        style = TextStyle(color = Color.White,
            fontSize =40.sp)
    )
}


@Composable
fun Mycomponent(){
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
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){
        Mytext("Comida para todos")
        Image(modifier = Modifier.size(500.dp,500.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la app",
            contentScale = ContentScale.Inside)
        Button(onClick = {context.startActivity(Intent(context,LoginActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)) {
            Text("Empezar",
                color = Color.Red,
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }


}


@Preview
@Composable
fun previewStart(){
    Mycomponent()
}