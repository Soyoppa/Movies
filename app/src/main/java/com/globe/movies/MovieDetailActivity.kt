package com.globe.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity : AppCompatActivity(){
    private lateinit var tvShowTitle: TextView
    private lateinit var rbShowRating: RatingBar
    private lateinit var ivShowPoster: ImageView
    private lateinit var tvShowPlot: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviedetail)
        tvShowTitle = findViewById(R.id.tvShowTitle)
        rbShowRating = findViewById(R.id.rbShowRating)
        ivShowPoster = findViewById(R.id.ivShowPoster)
        tvShowPlot = findViewById(R.id.tvShowPlot)


        val title = intent.getStringExtra("title")
        val plot = intent.getStringExtra("plot")
        val rating = intent.getDoubleExtra("rating",0.0)
        val poster = intent.getIntExtra("poster",0)

        //val movie : Movie = intent.getSerializableExtra()
        tvShowTitle.text = title
        tvShowPlot.text = plot
        rbShowRating.rating = rating.toFloat()
        ivShowPoster.setImageResource(poster)
    }
}

//get int extra
//get double extra