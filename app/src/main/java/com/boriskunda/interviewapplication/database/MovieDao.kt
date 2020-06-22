package com.boriskunda.interviewapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.boriskunda.interviewapplication.model.Movie

@Dao
interface MovieDao {

    @Insert
    fun insertAll(moviesList: List<Movie>)

    @Query("SELECT * from MOVIES_TABLE ORDER BY releaseYear DESC")
    fun getMoviesList(): LiveData<List<Movie>>

}