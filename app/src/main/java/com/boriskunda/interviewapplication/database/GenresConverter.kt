package com.boriskunda.interviewapplication.database

import androidx.room.TypeConverter

class GenresConverter {

    @TypeConverter
    fun fromGenres(listGenres: List<String>): String {
        return listGenres.joinToString(",")
    }

    @TypeConverter
    fun toGenres(data: String): List<String> {
        return data.split(",")
    }

}