package com.boriskunda.interviewapplication.database

import androidx.room.Dao
import androidx.room.Insert
import com.boriskunda.interviewapplication.model.Movie

@Dao
interface MovieDao {

    @Insert
    fun insertAll(movie: Movie)

}