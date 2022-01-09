package com.rskrobin.moviesapp.model.network

import com.rskrobin.moviesapp.model.entity.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/top_rated")
    suspend fun getListMovies(@Query("api_key") apiKey: String): MoviesListResponse
}