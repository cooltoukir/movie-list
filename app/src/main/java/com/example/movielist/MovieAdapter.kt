package com.example.movielist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.databinding.MovieRowBinding

class MovieAdapter(val callback: (Movie) -> Unit) : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffUtil()){

    class MovieViewHolder(val binding: MovieRowBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(movie: Movie) {
                binding.movie = movie
            }
        }

    class MovieDiffUtil : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            callback(movie)
        }
        holder.binding.btn.setOnClickListener {
            Log.d("MovieAdapter", "onBindViewHolder: ${movie.rating}")
        }
    }
}