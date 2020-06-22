package com.boriskunda.interviewapplication.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.boriskunda.interviewapplication.utilities.MOVIES_TABLE


//todo genres
//todo check if title can be val

@Entity(tableName = MOVIES_TABLE)
class Movie(
    @PrimaryKey
    @NonNull
    val title:String,
    val image:String,
    val rating:String,
    val releaseYear:String)