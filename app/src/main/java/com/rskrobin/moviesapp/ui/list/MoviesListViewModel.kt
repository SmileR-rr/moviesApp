package com.rskrobin.moviesapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rskrobin.moviesapp.model.NetworkMovieRepository
import com.rskrobin.moviesapp.model.entity.MoviesList
import kotlinx.coroutines.launch

class MoviesListViewModel : ViewModel() {

    private val network = NetworkMovieRepository()

    private val privateMoviesList = MutableLiveData<MoviesList>().apply {
        viewModelScope.launch { value = network.getListMovies() }
    }
    val moviesList: LiveData<MoviesList> = privateMoviesList
}