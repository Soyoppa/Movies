package com.globe.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    var movies:ArrayList<Movie> = ArrayList()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener:OnItemClickListener? = null
    //var onItemClicked:((Movie)Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)//tingan yung layout mo , convert nya yung android view mo

        val itemView = layoutInflater.inflate(R.layout.item_movie,parent,false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //bind mo yung movie mo don sa view
        val movie = movies[position]

        holder.tvTitle.text =  movie.title
        holder.rbRating.rating = movie.rating.toFloat()
        holder.ivMoviePoster.setImageResource(movie.poster)

        holder.ivMoviePoster.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v:View){
                onItemClickListener?.onItemClicked(holder.adapterPosition)
            }
        })
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val clickedMovie = movies.get(holder.adapterPosition)
                Log.d("Movie Adapter","Clicked position: $clickedMovie")
            }
        })
    }

    override fun getItemCount(): Int {
        //didictate sa recylvewholder kung gano kadamo ang dinidisplay naten
        return movies.size
    }

    class MovieViewHolder(itemView: View):ViewHolder(itemView){
        val ivMoviePoster : ImageView = itemView.findViewById(R.id.ivShowPoster)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val rbRating: RatingBar = itemView.findViewById(R.id.movieRating)
    }
}