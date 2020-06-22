package com.boriskunda.interviewapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.boriskunda.interviewapplication.MoviesAdapter
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.model.Movie
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_movies_list_ll.*

class MoviesListFragment : Fragment(),MoviesAdapter.OnRVItemClickListener {

    private val sharedViewModel: SharedViewModel by activityViewModels()//access ViewModel of activity,which fragment associates with

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list_ll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moviesAdapter = MoviesAdapter(this)

        movies_rv.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = moviesAdapter
        }

        sharedViewModel.moviesListLD.observe(viewLifecycleOwner, Observer {
            moviesAdapter.apply {
                moviesList = it
                notifyDataSetChanged()
            }
        })

    }

    override fun onRVItemClick(movie: Movie) {
         sharedViewModel.apply {
             setSelectedMovie(movie)
             openDetailsScreen()
         }
    }

}