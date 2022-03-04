package com.rskrobin.moviesapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rskrobin.moviesapp.model.MoviesPageSource
import com.rskrobin.moviesapp.model.NetworkMovieRepository
import com.rskrobin.moviesapp.model.entity.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: NetworkMovieRepository,
    private val moviesPageSource: MoviesPageSource
) : ViewModel() {

    /*private val privateMoviesList = MutableLiveData<MoviesList>().apply {
        viewModelScope.launch { value = moviesRepository.getListMovies() }
    }
    val moviesList: LiveData<MoviesList> = privateMoviesList*/

    val moviesList: StateFlow<PagingData<Movie>> = Pager(
        PagingConfig(10)
    ) {
        moviesPageSource
    }.flow.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}