package com.rskrobin.moviesapp.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rskrobin.moviesapp.R
import com.rskrobin.moviesapp.databinding.FragmentMoviesListBinding

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel by viewModels<MoviesListViewModel>()
        val binding = FragmentMoviesListBinding.bind(view)

        binding.moviesList.apply {
            adapter = MoviesListAdapter()
            layoutManager = LinearLayoutManager(view.context)
        }
    }
}