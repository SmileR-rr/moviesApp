package com.rskrobin.moviesapp.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class MoviesList(
    val page: Int,
    val movies: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)