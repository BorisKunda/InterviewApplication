package com.boriskunda.interviewapplication.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.ui.fragments.MovieDetailsFragment
import com.boriskunda.interviewapplication.ui.fragments.MoviesListFragment
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ll)

        supportFragmentManager.beginTransaction().replace(R.id.fr_container, MoviesListFragment()).commit()
        observeViewModel(sharedViewModel)

    }

    private fun observeViewModel(sharedVM:SharedViewModel) {

        //todo better animations
        sharedVM.openDetailsScreenLD.observe(this, Observer {
            supportFragmentManager.beginTransaction().setCustomAnimations(//todo check default animations
              R.anim.slide_in_right ,
              R.anim.slide_out_left ,
              R.anim.slide_in_left ,
              R.anim.slide_out_right
            ).replace(R.id.fr_container, MovieDetailsFragment()).addToBackStack(null).commit()
        })

    }

}