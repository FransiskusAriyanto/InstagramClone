package com.example.instagramclone.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

    private const val baseURL = "https://hp-api.onrender.com/api/"
    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }

}