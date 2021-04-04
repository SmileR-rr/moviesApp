package com.rskrobin.moviesapp.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rskrobin.moviesapp.R
import com.rskrobin.moviesapp.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel by viewModels<MovieDetailsViewModel>()
        val binding = FragmentMovieDetailsBinding.bind(view)
    }
}