package com.boriskunda.interviewapplication.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.boriskunda.interviewapplication.utilities.MOVIES_TABLE
import com.google.gson.annotations.SerializedName


@Entity(tableName = MOVIES_TABLE)
class Movie(
    @PrimaryKey
    @NonNull
    val title: String,
    @SerializedName("image")
    val posterUrl: String,
    val rating: String,
    val releaseYear: String,
    @SerializedName("genre")
    val genresList: List<String>
)
