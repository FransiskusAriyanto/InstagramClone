package com.example.instagramclone.service

import com.example.instagramclone.model.MyModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("characters")
    fun gelAllData(): Call<List<MyModel>>


    @GET("character{id}")
    fun getDetail(@Path("id") id: String?) : Call<MyModel>

//    @GET("character{id}")
//    fun getDetail(@Query("id") id: String?) : Call<List<MyModel>>
}