package com.example.movielist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movielist.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val bundle = arguments
        binding.movieNameTV.text = bundle?.getString("movie_name")
        binding.movieCategoryTV.text = bundle?.getString("movie_category")
        binding.movieRatingTV.text = bundle?.getString("movie_rating").toString()
        return binding.root
    }
}