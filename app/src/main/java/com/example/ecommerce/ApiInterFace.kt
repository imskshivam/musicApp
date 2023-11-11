package com.example.ecommerce

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterFace {
    @Headers("X-RapidAPI-Key:48940ce708msh202a907a6fdccf0p18fcd8jsnd111c46d2fa5","X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query:String) : Call<MyData>
}