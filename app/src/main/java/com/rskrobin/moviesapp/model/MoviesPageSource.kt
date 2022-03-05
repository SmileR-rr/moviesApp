package com.rskrobin.moviesapp.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rskrobin.moviesapp.BuildConfig
import com.rskrobin.moviesapp.model.entity.Movie
import com.rskrobin.moviesapp.model.entity.MovieResponse
import com.rskrobin.moviesapp.model.entity.MoviesList
import com.rskrobin.moviesapp.model.entity.MoviesListResponse
import com.rskrobin.moviesapp.model.network.MovieApi
import javax.inject.Inject

class MoviesPageSource @Inject constructor(
    private val movieApi: MovieApi
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1

        val response = movieApi.getListMovies(BuildConfig.API_KEY, page).toMoviesList()
        val prevKey = if (page == 1) null else page - 1
        return LoadResult.Page(response.movies, prevKey, page + 1)
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