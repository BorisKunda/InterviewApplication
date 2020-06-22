package com.boriskunda.interviewapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso

class MovieDetailsFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_details_ll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.selectedMovieLD.observe(viewLifecycleOwner,
            Observer {

                val title: TextView = view.findViewById(R.id.movie_details_title_tv)
                val releaseDate: TextView = view.findViewById(R.id.movie_details_date_tv)
                val rating: TextView = view.findViewById(R.id.movie_details_rating_tv)
                val genres: TextView = view.findViewById(R.id.movie_details_genres_tv)
                val poster: ImageView = view.findViewById(R.id.movie_details_poster_iv)

                title.text = it.title
                releaseDate.text = it.releaseYear
                rating.text = it.rating
                genres.text = it.genresList.joinToString(", ")

                Picasso.get().load(it.posterUrl).placeholder(R.drawable.ic_movie_place_holder)
                    .error(R.drawable.ic_place_holder_error).into(poster)

            }
        )
    }

}