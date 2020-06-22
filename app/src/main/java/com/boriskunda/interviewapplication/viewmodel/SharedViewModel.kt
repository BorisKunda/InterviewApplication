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
    private val openDetailsScreenSLE: SingleLiveEvent<Boolean> = SingleLiveEvent()
    private val selectedMovieMLD: MutableLiveData<Movie> = MutableLiveData()
    val selectedMovieLD: LiveData<Movie> = selectedMovieMLD
    val openDetailsScreenLD: LiveData<Boolean> = openDetailsScreenSLE
    val moviesListLD: LiveData<List<Movie>> = repository.moviesList

    fun loadMovies() {
        repository.loadMoviesFromServer()
    }

    fun setSelectedMovie(movie: Movie) {
        selectedMovieMLD.value = movie
    }

    fun openDetailsScreen() {
        openDetailsScreenSLE.call()
    }

}