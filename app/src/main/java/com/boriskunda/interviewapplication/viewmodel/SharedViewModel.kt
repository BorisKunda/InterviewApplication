package com.boriskunda.interviewapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.boriskunda.interviewapplication.Repository
import com.boriskunda.interviewapplication.utilities.SingleLiveEvent

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = Repository.instance
    private val someSLE: SingleLiveEvent<Boolean> = SingleLiveEvent()
    private val app: Application = application

}