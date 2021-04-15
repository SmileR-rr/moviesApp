package com.rskrobin.moviesapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rskrobin.moviesapp.R
import com.rskrobin.moviesapp.databinding.ItemFilmBinding

class MoviesListAdapter() : RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {

    var listMovies = mutableListOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.run {
        binding.name.text = listMovies[position]
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemFilmBinding.bind(itemView)
    }
}