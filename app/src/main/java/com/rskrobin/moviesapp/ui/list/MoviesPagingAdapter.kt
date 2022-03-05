package com.rskrobin.moviesapp.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rskrobin.moviesapp.BuildConfig
import com.rskrobin.moviesapp.R
import com.rskrobin.moviesapp.databinding.ItemFilmBinding
import com.rskrobin.moviesapp.model.entity.Movie

class MoviesPagingAdapter(context: Context) :
    PagingDataAdapter<Movie, MoviesPagingAdapter.MovieViewHolder>(MovieDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int): Unit = holder.run {
        val movie = getItem(position)
        binding.apply {
            logoMovie.load(BuildConfig.BASE_IMAGE_URL + movie?.posterPath)
            name.text = movie?.title
            ratingBar.rating = (movie?.voteAverage?.div(2))?.toFloat() ?: 0f
        }
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