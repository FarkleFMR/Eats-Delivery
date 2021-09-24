package com.example.eats

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("get")
    suspend fun get(name:String): Response<RestaurantResponse>
}