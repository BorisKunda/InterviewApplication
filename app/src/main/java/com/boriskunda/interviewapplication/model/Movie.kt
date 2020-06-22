package com.boriskunda.interviewapplication.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


//todo genres
//todo check if title can be val

@Entity
class Movie(
    @PrimaryKey
    @NonNull
    var title:String,
    image:String, rating:String, releaseYear:String) {



}