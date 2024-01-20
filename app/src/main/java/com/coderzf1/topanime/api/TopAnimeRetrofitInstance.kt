package com.coderzf1.topanime.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TopAnimeRetrofitInstance {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:TopAnimeApi by lazy {
        retrofit.create(TopAnimeApi::class.java)
    }
}