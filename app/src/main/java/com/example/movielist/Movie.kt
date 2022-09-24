package com.example.movielist

data class Movie(
    val id: Int,
    val name: String,
    val category: String,
    var rating: Double,
    var poster: Int = R.drawable.poster
)

val movieList = mutableListOf<Movie>(
    Movie(1, "Titanic", "Drama", 8.2),
    Movie(2, "Transformers", "Action", 9.0),
    Movie(3, "Brave Heart", "Thrillers", 9.2),
    Movie(4, "Mechanic", "Drama", 7.5),
    Movie(5, "Total Recall", "Action", 5.0),
    Movie(6, "Avengers: End Game", "Action", 9.5),
    Movie(7, "Ace Ventura:Pet Detective", "Drama", 8.5),
    Movie(8, "Ace Ventura:When Nature Calls", "Drama", 8.5),
    Movie(9, "Transporter", "Action", 7.0),
    Movie(10, "Terminator 2", "Action", 9.5)
)
