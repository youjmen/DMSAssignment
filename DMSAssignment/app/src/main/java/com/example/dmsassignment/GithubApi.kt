package com.example.dmsassignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(GithubService::class.java)
}