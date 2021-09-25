package com.example.eats

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.temporal.TemporalQuery

class MenuActivity : ComponentActivity() {
    var resnombre = String
    val image = String
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uimenu()
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchbyName(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).get("restaurant/restaurant/Mex-Eats")
            val restaurantes : RestaurantResponse? = call.body()
            if(call.isSuccessful){
               Log.d("MenuActivity","onCreate: ${restaurantes}")

            }else{
                showError()
            }
        }
    }

    private fun showError() {
        Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show()
    }
}

@ExperimentalMaterialApi
@Composable
fun Uimenu(){
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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {context.startActivity(Intent(context,UserInfoActivity::class.java))}) {
                Icon(
                    Icons.Filled.List,
                    contentDescription = "Settings Icon")
            }
            IconButton(onClick = {context.startActivity(Intent(context,MenuActivity::class.java))}) {
                Icon(
                    Icons.Filled.CheckCircle,
                    contentDescription = "Cart Icon")
            }
        }
        Card(onClick = {context.startActivity(Intent(context,RestauranteInfo::class.java)) },
            shape = RoundedCornerShape(20.dp),
            elevation = 100.dp
        ) {
            Column(modifier = Modifier.padding(16.dp),) {
                Image(
                    modifier = Modifier.height(200.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Restaurante",
                    contentScale = ContentScale.Crop
                )
                
                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "Mex-Eats",
                    style = TextStyle(fontSize = 17.sp)
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text("Tejar el Guarco,Cartago")
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Home,
                    "Buton al menu",
                    tint = Color.White
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun previewMenu(){
    Uimenu()
}