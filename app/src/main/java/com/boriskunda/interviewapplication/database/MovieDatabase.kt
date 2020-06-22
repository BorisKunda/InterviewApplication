package com.boriskunda.interviewapplication.database

import android.app.Application
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.boriskunda.interviewapplication.model.Movie
import com.boriskunda.interviewapplication.utilities.DATABASE_NAME


@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        fun getMovieDatabase(application: Application): MovieDatabase {

            Log.DEBUG

            val movieDatabase: MovieDatabase by lazy {
                Room.databaseBuilder(
                    application,
                    MovieDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }

            Log.DEBUG

            return movieDatabase

        }

    }


}
