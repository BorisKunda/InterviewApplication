package com.boriskunda.interviewapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.boriskunda.interviewapplication.model.Movie
import com.squareup.picasso.Picasso

//todo check if private is necessary
class MoviesAdapter(private val onRVItemClickListener:OnRVItemClickListener) : RecyclerView.Adapter<MoviesAdapter.VH>() {

    var moviesList: List<Movie> = mutableListOf()

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val movieTitleTV: TextView = itemView.findViewById(R.id.movie_title_tv)
        val moviePosterIV: ImageView = itemView.findViewById(R.id.movie_poster_iv)
        val movieReleaseYearTV: TextView = itemView.findViewById(R.id.movie_release_year_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.movie_rv_item_ll, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val movie = moviesList[position]
        holder.movieTitleTV.text = movie.title
        holder.movieReleaseYearTV.text = movie.releaseYear

        Picasso.get().load(movie.posterUrl).placeholder(R.drawable.ic_movie_place_holder)
            .error(R.drawable.ic_place_holder_error).into(holder.moviePosterIV)

        holder.itemView.setOnClickListener {
            onRVItemClickListener.onRVItemClick(movie)
        }

    }

    interface OnRVItemClickListener {
        fun onRVItemClick(movie: Movie)
    }

}