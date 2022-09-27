package com.globe.movies

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private val movieAdapter = MovieAdapter()

    private val movies: ArrayList<Movie> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMovies = findViewById(R.id.rvMovies)
        initializedMovies()


        movieAdapter.onItemClickListener = object : OnItemClickListener{
            override fun onItemClicked(position: Int) {
                val selectedMovie = movieAdapter.movies.get(position)
                movieDetail(position)
                Log.d("MainActivity", "Movie Clicked $selectedMovie")
            }
        }

    }

    private fun initializedMovies(){
        movies.add(Movie("Gagamboy",R.drawable.gagamboy,5.0,"An accident at a pharmaceutical lab turns the mild-mannered and unassuming Junie, an ice cream vendor, into a superhero. Junie finds out that being strong and admired can also have its downside."))
        movies.add(Movie("Enteng Kabisote",R.drawable.enteng_kabisote,3.0,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        movies.add(Movie("My Neighbor Totoro",R.drawable.totoro,5.0,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        movies.add(Movie("Spirited Home",0,3.0,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        movies.add(Movie("Spirited Far From Home",0,5.0,"        able.sister_and_a_wedding,5,Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.)"))
        movies.add(Movie("How I met your Mother",R.drawable.himym,5.0,"      awable.sister_and_a_wedding,5,Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.))"))
        movies.add(Movie("Spirited homecoming",0,5.0,"simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ind"))
        movies.add(Movie("Spirited Away",R.drawable.spirited_away,5.0,"simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ind"))
        movies.add(Movie("Spirited Fafa Away",0,5.0,"dummy text of the printing and typesetting industry. Lorem"))


        movieAdapter.movies = movies
        rvMovies.adapter =movieAdapter
        Log.d("MainActivity",movies.toString())

    }

    fun movieDetail(moviePosition: Int){
        val selectedMovie: Movie = movieAdapter.movies.get(moviePosition)
        val movieDetailIntent = Intent(this,MovieDetailActivity::class.java)
        movieDetailIntent.putExtra("title",selectedMovie.title)
        movieDetailIntent.putExtra("poster",selectedMovie.poster)
        movieDetailIntent.putExtra("rating",selectedMovie.rating)
        movieDetailIntent.putExtra("plot",selectedMovie.plot)
        startActivity(movieDetailIntent)
    }
}