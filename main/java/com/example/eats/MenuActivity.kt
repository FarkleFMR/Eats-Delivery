package com.example.eats

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun Uimenu(){

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
        verticalArrangement = Arrangement.SpaceEvenly){
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.List,
                    contentDescription = "Cart Icon")
            }
        }
        Image(modifier = Modifier.height(300.dp),
            painter = painterResource(id = R.drawable.creditcardicon),
            contentDescription = "Restaurante",
            contentScale = ContentScale.Crop)
        Column(modifier = Modifier.padding(16.dp),){
            Text(text = "Good Morning Sunshine",
                style = TextStyle(fontSize = 17.sp)
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text("Tejar el Guarco,Cartago")
        }
    }
}

@Preview
@Composable
fun previewMenu(){
    Uimenu()
}