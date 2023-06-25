package com.example.instagramclone.service

import com.example.instagramclone.model.MyModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("characters")
    fun gelAllData(): Call<List<MyModel>>

    @GET("character/{id}")
    fun gelAllDetail(@Query("id") id: String?) : Call<MyModel>

//    @GET("character/")
//    fun gelAllDetail(@Path("id") type: String?) : Call<MyModel>
}