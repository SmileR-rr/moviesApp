package com.rskrobin.moviesapp.model

import com.rskrobin.moviesapp.BuildConfig
import com.rskrobin.moviesapp.model.entity.Movie
import com.rskrobin.moviesapp.model.entity.MovieResponse
import com.rskrobin.moviesapp.model.entity.MoviesList
import com.rskrobin.moviesapp.model.entity.MoviesListResponse
import com.rskrobin.moviesapp.model.network.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkMovieRepository @Inject constructor(
    private val movieApi: MovieApi
) {
    suspend fun getListMovies() = withContext(Dispatchers.IO) {
        movieApi.getListMovies(BuildConfig.API_KEY,1).toMoviesList()
    }
}

private fun MoviesListResponse.toMoviesList() = MoviesList(
    page = page,
    movies = movies.map { it.toMovie() },
    totalPages = totalPages,
    totalResults = totalResults
)

private fun MovieResponse.toMovie() = Movie(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)
