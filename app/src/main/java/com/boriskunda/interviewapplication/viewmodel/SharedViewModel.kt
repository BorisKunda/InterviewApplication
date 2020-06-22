package com.boriskunda.interviewapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.boriskunda.interviewapplication.Repository
import com.boriskunda.interviewapplication.model.Movie
import com.boriskunda.interviewapplication.utilities.SingleLiveEvent

class SharedViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: Repository = Repository.getRepoInstance(application)

    //private val someSLE: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val moviesListLD: LiveData<List<Movie>> = repository.moviesList

    fun loadMovies() {
        repository.loadMoviesFromServer()
    }

}