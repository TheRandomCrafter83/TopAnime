package com.coderzf1.topanime.api

import com.coderzf1.topanime.repository.models.TopAnime
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimeApi {
    @GET("top/anime")
    suspend fun getTopAnime():Response<TopAnime>
}