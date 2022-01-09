package com.rskrobin.moviesapp.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesListResponse(
    @SerialName("page")
    val page: Int,

    @SerialName("results")
    val movies: List<MovieResponse>,

    @SerialName("total_pages")
    val totalPages: Int,

    @SerialName("total_results")
    val totalResults: Int
)
