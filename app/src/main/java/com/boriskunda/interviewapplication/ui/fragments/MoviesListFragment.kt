package com.boriskunda.interviewapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boriskunda.interviewapplication.R

class MoviesListFragment : Fragment() {

    //private val sharedViewModel: SharedViewModel by activityViewModels()//access ViewModel of activity,which fragment associates with

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

}