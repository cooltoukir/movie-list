package com.example.movielist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        val adapter = MovieAdapter(::onReceiveMovieFromAdapter)
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.movieRecyclerView.adapter = adapter
        adapter.submitList(movieList)
        return binding.root
    }

    private fun onReceiveMovieFromAdapter(movie: Movie) {
        val bundle = Bundle().apply {
            putString("movie_name", movie.name)
            putString("movie_category", movie.category)
            putDouble("movie_rating", movie.rating)
        }
        findNavController()
            .navigate(R.id.action_homeFragment_to_movieDetailsFragment, bundle)
    }
}