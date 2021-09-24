package com.example.eats

import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("idRestaurant") var idRestaurante:Int,
    @SerializedName("name")var nombre:String,
    @SerializedName("image")var imagen:String,
    @SerializedName("shippingcost")var envio:Int,
    @SerializedName("deleted")var borrado:Int,
    @SerializedName("idRestaurantCategory")var idCategoria:Int,
    @SerializedName("idAdmin")var idAdmin:Int
    )
