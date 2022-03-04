package com.rskrobin.moviesapp.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rskrobin.moviesapp.R
import com.rskrobin.moviesapp.databinding.ItemFilmBinding
import com.rskrobin.moviesapp.model.entity.Movie

class MoviesPagingAdapter(context: Context) :
    PagingDataAdapter<Movie, MoviesPagingAdapter.MovieViewHolder>(MovieDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.run {
        val ttt = getItem(position)?.backdropPath
        val tttt = getItem(position)?.posterPath
        val ttttt = getItem(position)?.overview
        binding.logoMovie.load(getItem(position)?.backdropPath)
        binding.name.text = getItem(position)?.title
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemFilmBinding.bind(itemView)
    }
}

private object MovieDiffItemCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.title == newItem.title && oldItem.id == newItem.id
    }

}