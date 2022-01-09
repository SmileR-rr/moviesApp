package com.rskrobin.moviesapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rskrobin.moviesapp.model.NetworkMovieRepository
import com.rskrobin.moviesapp.model.entity.MoviesList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: NetworkMovieRepository
) : ViewModel() {

    private val privateMoviesList = MutableLiveData<MoviesList>().apply {
        viewModelScope.launch { value = moviesRepository.getListMovies() }
    }
    val moviesList: LiveData<MoviesList> = privateMoviesList
}