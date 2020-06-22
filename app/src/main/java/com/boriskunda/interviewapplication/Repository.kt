package com.boriskunda.interviewapplication

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.boriskunda.interviewapplication.database.MovieDatabase

class Repository private constructor(application: Application) {

    private val movieDatabase: MovieDatabase
    private val volleyRequestQueue: RequestQueue

    init {
        movieDatabase = MovieDatabase.getMovieDatabase(application)
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


}