package com.boriskunda.interviewapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso

class MovieDetailsFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()//access ViewModel of activity,which fragment associates with

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details_ll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val i = view.findViewById<ImageView>(R.id.iv)

        sharedViewModel.selectedMovieLD.observe(viewLifecycleOwner,
            Observer {
                Picasso.get().load(it.posterUrl).placeholder(R.drawable.ic_movie_place_holder)
                    .error(R.drawable.ic_place_holder_error).into(i)
            }
        )
    }

}