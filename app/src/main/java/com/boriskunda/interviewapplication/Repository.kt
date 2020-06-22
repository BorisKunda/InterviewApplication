package com.boriskunda.interviewapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.boriskunda.interviewapplication.database.MovieDao
import com.boriskunda.interviewapplication.database.MovieDatabase
import com.boriskunda.interviewapplication.model.Movie
import com.boriskunda.interviewapplication.utilities.GET_ALL_COUNTRIES_URL

class Repository private constructor(application: Application) {

    private val volleyRequestQueue: RequestQueue
    private val movieDao: MovieDao
    val moviesList: LiveData<List<Movie>>

    init {
        val db = MovieDatabase.getMovieDatabase(application)
        movieDao = db.movieDao()
        moviesList = movieDao.getMoviesList()
        volleyRequestQueue = Volley.newRequestQueue(application)
    }


    companion object {

        fun getRepoInstance(application: Application): Repository {

            val instance: Repository by lazy { Repository(application) }
            /**
            The by lazy{}indicates it will be computed on the first access only.
            The evaluation of lazy properties is synchronized, the value is computed only in one thread,
            and all threads will see the same value.
             */
            return instance

        }

    }

    fun loadMoviesFromServer() {
        JsonArrayRequest(
            Request.Method.GET,
            GET_ALL_COUNTRIES_URL,
            null,

            Response.Listener {
                Log.e("loadMoviesFromServer: ", "json:$it")
            },

            Response.ErrorListener { TODO("to be implemented")}
        ).let {
            volleyRequestQueue.add(it)
        }
    }

}