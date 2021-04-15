package com.rskrobin.moviesapp.model

import com.rskrobin.moviesapp.BuildConfig
import com.rskrobin.moviesapp.model.network.RetrofitModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkMovieRepository() {

    private val movieApi = RetrofitModule.movieApi

    suspend fun getListMovies() = withContext(Dispatchers.IO) {
        movieApi.getListMovies(BuildConfig.API_KEY)
    }
}