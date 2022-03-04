package com.rskrobin.moviesapp.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rskrobin.moviesapp.R
import com.rskrobin.moviesapp.databinding.FragmentMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel by viewModels<MoviesListViewModel>()
        val binding = FragmentMoviesListBinding.bind(view)
        val adapterPaging = MoviesPagingAdapter(requireContext())


        binding.moviesList.apply {
            adapter = adapterPaging
            /*adapter = MoviesListAdapter().apply {
                viewModel.moviesList.observe(viewLifecycleOwner) {
                    moviesList = it.movies
                }
            }*/
            layoutManager = GridLayoutManager(view.context,2)
        }
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.moviesList.collectLatest(adapterPaging::submitData)
            }
        }
    }
}