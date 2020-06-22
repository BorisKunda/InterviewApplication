package com.boriskunda.interviewapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.utilities.SPLASH_DURATION
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel

class SplashActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        Handler().postDelayed({
//
//            Intent(this@SplashActivity, MainActivity::class.java).let {
//                startActivity(it)
//                finish()
//            }
//
//        }, SPLASH_DURATION)

        sharedViewModel.loadMovies()

    }
}