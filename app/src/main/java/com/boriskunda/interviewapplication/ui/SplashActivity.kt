package com.boriskunda.interviewapplication.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.utilities.SPLASH_DURATION

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            Intent(this@SplashActivity, MainActivity::class.java).let {
                startActivity(it)
                finish()
            }

        }, SPLASH_DURATION)

    }
}